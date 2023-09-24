package com.nosuchfield.jinx.instruction;

import com.nosuchfield.jinx.code.JinxLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VariableInstruction implements Instruction, Opcodes {

    /**
     * 变量索引
     */
    private final int id;

    /**
     * 变量类型
     */
    private final int type;

    /**
     * 变量的值
     */
    private final String value;

    public VariableInstruction(int id, int type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    @Override
    public void apply(MethodVisitor mv) {
        System.out.printf("id=%d type=%d value=%s \n", id, type, value);
        if (type == JinxLexer.DOUBLE) {
            double val = Double.parseDouble(value);
            // 常量池的数据推到栈顶
            mv.visitLdcInsn(val);
            // 栈顶double值存入本地变量
            mv.visitVarInsn(DSTORE, id);
        } else if (type == JinxLexer.INT) {
            int val = Integer.parseInt(value);
            mv.visitLdcInsn(val);
            mv.visitVarInsn(ISTORE, id);
        } else if (type == JinxLexer.STRING) {
            mv.visitLdcInsn(value);
            mv.visitVarInsn(ASTORE, id);
        }
    }

}
