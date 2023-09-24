package com.nosuchfield.jinx.instruction;

import com.nosuchfield.jinx.code.JinxLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PrintInstruction implements Instruction, Opcodes {

    /**
     * 操作第几个变量
     */
    private final int id;

    /**
     * 对应的这个变量的类型
     */
    private final int type;

    public PrintInstruction(int id, int type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public void apply(MethodVisitor mv) {
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == JinxLexer.INT) {
            mv.visitVarInsn(ILOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        } else if (type == JinxLexer.DOUBLE){
            mv.visitVarInsn(DLOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
        }else if (type == JinxLexer.STRING) {
            mv.visitVarInsn(ALOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
    }

}
