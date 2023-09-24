package com.nosuchfield.jinx.instruction;

import com.nosuchfield.jinx.Utils;
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
                // 常量池的数据推到栈顶
                mv.visitLdcInsn(val);
                // 栈顶double值存入本地局部变量，idx代表索引
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
