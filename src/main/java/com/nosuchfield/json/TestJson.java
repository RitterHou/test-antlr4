package com.nosuchfield.json;

import com.nosuchfield.json.code.JsonLexer;
import com.nosuchfield.json.code.JsonParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

public class TestJson {

    @Test
    public void testJson() throws IOException {
        JsonLexer lexer = new JsonLexer(CharStreams.fromFileName("src/main/resources/json/data.json"));
        // 移除Lexer默认的错误处理器
        lexer.removeErrorListeners();
        // 给Lexer新增错误处理器
        lexer.addErrorListener(new JsonErrorHandler());

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonParser parser = new JsonParser(tokens);
        // 移除Parser默认的错误处理器
        parser.removeErrorListeners();
        // 新增Parser自定义的错误处理器
        parser.addErrorListener(new JsonErrorHandler());

        ParseTree tree = parser.json();
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        JsonListener listener = new JsonListener();
        parseTreeWalker.walk(listener, tree);
        System.out.println(listener.getResult());
    }

}
