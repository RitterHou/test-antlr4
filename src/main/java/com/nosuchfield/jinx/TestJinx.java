package com.nosuchfield.jinx;

import org.junit.Test;

public class TestJinx {

    @Test
    public void testJinx() {
        Compiler.INSTANCE.compile("src/main/resources/jinx/test.jinx");
    }

}