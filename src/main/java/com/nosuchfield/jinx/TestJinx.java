package com.nosuchfield.jinx;

import com.nosuchfield.jinx.compile.Compiler;
import org.junit.Test;

/**
 * 编译到Java字节码
 * <a href="http://jakubdziworski.github.io/enkel/2016/04/05/enkel_7_methods.html">Creating JVM language</a>
 */
public class TestJinx {

    @Test
    public void testJinx() {
        Compiler.getInstance().compile("src/main/resources/jinx/test.jinx");
    }

}
