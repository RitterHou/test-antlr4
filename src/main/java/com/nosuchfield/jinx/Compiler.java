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

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class Compiler {

    public static Compiler INSTANCE = new Compiler();

    public void compile(String file) {
        JinxLexer lexer;
        try {
            lexer = new JinxLexer(CharStreams.fromFileName(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JinxParser parser = new JinxParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorHandler());
        ParseTree tree = parser.jinx();
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        Loader loader = new Loader();
        parseTreeWalker.walk(loader, tree);
        List<Instruction> instructions = loader.getInstructions();

        writeByteArrayToFile("Jinx.class", generateBytecode(instructions, "Jinx"));
    }

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
        mv.visitMaxs(100, (int) localVariablesCount + 1);
        mv.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }

    private void writeByteArrayToFile(String name, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(name)) {
            fos.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
