package com.nosuchfield.jinx.instruction;

import com.nosuchfield.jinx.code.JinxLexer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class VariableInstruction implements Instruction, Opcodes {

    private final int id;

    private final int type;

    private final String value;

    public VariableInstruction(int id, int type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    @Override
    public void apply(MethodVisitor mv) {
        if (type == JinxLexer.NUMBER) {
            int val = Integer.parseInt(value);
            mv.visitIntInsn(BIPUSH, val);
            mv.visitVarInsn(ISTORE, id);
        } else if (type == JinxLexer.STRING) {
            mv.visitLdcInsn(value);
            mv.visitVarInsn(ASTORE, id);
        }
    }

}
