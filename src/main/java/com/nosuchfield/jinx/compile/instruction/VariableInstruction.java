package com.nosuchfield.jinx.compile.instruction;

import com.nosuchfield.jinx.common.Utils;
import com.nosuchfield.jinx.code.JinxLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VariableInstruction implements Instruction, Opcodes {

    /**
     * 变量索引
     */
    private final int idx;

    /**
     * 变量类型
     */
    private final int type;

    /**
     * 变量的值
     */
    private final String value;

    public VariableInstruction(int idx, int type, String value) {
        this.idx = idx;
        this.type = type;
        this.value = value;
    }

    @Override
    public void apply(MethodVisitor mv) {
        switch (type) {
            case JinxLexer.DOUBLE -> {
                double val = Double.parseDouble(value);
                // 虚拟机栈 -> 栈帧 -> 操作数栈、局部变量表
                // val会被存在常量池中，并将常量池中的这个变量推到操作数栈顶
                mv.visitLdcInsn(val);
                // 操作数栈顶的double值存入本地局部变量，idx代表本地变量表的索引
                mv.visitVarInsn(DSTORE, idx);
            }
            case JinxLexer.INT -> {
                int val = Integer.parseInt(value);
                mv.visitLdcInsn(val);
                mv.visitVarInsn(ISTORE, idx);
            }
            case JinxLexer.STRING -> {
                mv.visitLdcInsn(Utils.removeFirstAndLastChar(value));
                mv.visitVarInsn(ASTORE, idx);
            }
        }
    }

}
