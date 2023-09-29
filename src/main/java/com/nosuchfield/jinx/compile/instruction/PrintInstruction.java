package com.nosuchfield.jinx.compile.instruction;

import com.nosuchfield.jinx.code.JinxLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PrintInstruction implements Instruction, Opcodes {

    /**
     * 操作第几个变量
     */
    private final int idx;

    /**
     * 对应的这个变量的类型
     */
    private final int type;

    public PrintInstruction(int idx, int type) {
        this.idx = idx;
        this.type = type;
    }

    @Override
    public void apply(MethodVisitor mv) {
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        switch (type) {
            case JinxLexer.INT -> {
                mv.visitVarInsn(ILOAD, idx);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            }
            case JinxLexer.DOUBLE -> {
                mv.visitVarInsn(DLOAD, idx);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            }
            case JinxLexer.STRING -> {
                mv.visitVarInsn(ALOAD, idx);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            }
        }
    }

}
