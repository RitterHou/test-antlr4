package com.nosuchfield.jinx.instruction;

import org.objectweb.asm.MethodVisitor;

public interface Instruction {

    void apply(MethodVisitor mv);

}
