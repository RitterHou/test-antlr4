package com.nosuchfield.jinx.compile;

import com.nosuchfield.jinx.code.JinxLexer;
import com.nosuchfield.jinx.code.JinxParser;
import com.nosuchfield.jinx.instruction.Instruction;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class Compiler {

    private volatile static Compiler compiler;

    private Compiler() {
    }

    public static Compiler getInstance() {
        if (compiler == null) {
            synchronized (Compiler.class) {
                if (compiler == null) {
                    compiler = new Compiler();
                }
            }
        }
        return compiler;
    }

    public void compile(String file) {
        try {
            compile0(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void compile0(String file) throws IOException {
        // 词法分析
        JinxLexer lexer = new JinxLexer(CharStreams.fromFileName(file));
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
        String className = loader.getClassName();
        String classFile = Paths.get(new File(file).getParent(), className + ".class").toString();
        writeByteArrayToFile(classFile, generateBytecode(instructions, className));
    }

    /**
     * 将指令转化为class文件
     *
     * @param instructions 指令列表
     * @param className    类名
     * @return class文件
     */
    private byte[] generateBytecode(List<Instruction> instructions, String className) {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_8, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null);
        // main方法
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "main",
                "([Ljava/lang/String;)V", null, null);
        for (Instruction instruction : instructions) {
            instruction.apply(methodVisitor);
        }
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(0, 0); // 设置COMPUTE_FRAMES后会自动计算，但是此处设置不能省略
        methodVisitor.visitEnd();
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }

    private void writeByteArrayToFile(String file, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        }
    }

}
