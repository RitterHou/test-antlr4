package com.nosuchfield.jinx.compile.instruction;

import org.objectweb.asm.MethodVisitor;

public interface Instruction {

    void apply(MethodVisitor mv);

}
