package org.example.antlr.csv;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.example.antlr.csv.code.CsvLexer;
import org.example.antlr.csv.code.CsvParser;
import org.junit.Test;

import java.io.IOException;

public class TestCsv {

    @Test
    public void testCsv() throws IOException {
        CsvLexer lexer = new CsvLexer(CharStreams.fromFileName("src/main/resources/csv/city.csv"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CsvParser parser = new CsvParser(tokens);
        ParseTree tree = parser.csv();
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        CsvListener listener = new CsvListener();
        parseTreeWalker.walk(listener, tree);
        System.out.println(listener.getRows());
    }

}
