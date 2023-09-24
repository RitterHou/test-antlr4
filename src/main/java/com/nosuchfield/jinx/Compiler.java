package com.nosuchfield.jinx;

import com.nosuchfield.jinx.code.JinxLexer;
import com.nosuchfield.jinx.code.JinxParser;
import com.nosuchfield.jinx.instruction.Instruction;
import com.nosuchfield.jinx.instruction.VariableInstruction;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class Compiler {

    public static Compiler INSTANCE = new Compiler();

    public void compile(String file) {
        try {
            compile0(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void compile0(String file) throws IOException {
        // 词法分析
        JinxLexer lexer  = new JinxLexer(CharStreams.fromFileName(file));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 语法分析
        JinxParser parser = new JinxParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorHandler()); // 语法分析错误处理
        ParseTree tree = parser.jinx();
        // 语法树遍历
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        Loader loader = new Loader();
        parseTreeWalker.walk(loader, tree);
        // 遍历语法树生成Java指令
        List<Instruction> instructions = loader.getInstructions();
        // 生成Java.class文件
        writeByteArrayToFile(file.replace(".jinx",".class"),
                generateBytecode(instructions, new File(file).getName().replace(".jinx","")));
    }

    /**
     * 将指令转化为class文件
     * @param instructions 指令列表
     * @param className 类名
     * @return class文件
     */
    private byte[] generateBytecode(List<Instruction> instructions, String className) {
        ClassWriter cw = new ClassWriter(0);
        // 类
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null);
        // main方法
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        long localVariablesCount = instructions.stream()
                .filter(instruction -> instruction instanceof VariableInstruction)
                .count();
        for (Instruction instruction : instructions) {
            instruction.apply(mv);
        }
        mv.visitInsn(RETURN);
        mv.visitMaxs(100, (int) localVariablesCount + 10);
        mv.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }

    private void writeByteArrayToFile(String file, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}