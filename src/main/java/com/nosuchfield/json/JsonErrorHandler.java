package com.nosuchfield.json;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Collections;
import java.util.List;

public class JsonErrorHandler extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.err.printf("failed: %s\n", msg);
        System.err.printf("    at %s:%s:%d\n", recognizer.getInputStream().getSourceName(), line, charPositionInLine);
        System.err.printf("    at %s stack: %s\n", offendingSymbol, String.join(" -> ", stack));
        System.exit(1);
    }

}
