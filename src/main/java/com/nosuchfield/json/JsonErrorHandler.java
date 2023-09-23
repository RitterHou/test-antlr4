package com.nosuchfield.json;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class JsonErrorHandler extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        System.err.printf("failed: %s\n", msg);
        System.err.printf("    at %s:%s:%d\n", recognizer.getInputStream().getSourceName(), line, charPositionInLine);
        System.exit(1);
    }

}
