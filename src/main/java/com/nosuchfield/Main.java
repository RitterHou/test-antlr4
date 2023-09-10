package com.nosuchfield;

import com.nosuchfield.antlr4.CalcLexer;
import com.nosuchfield.antlr4.CalcParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        String[] sources = new String[]{
                "1 + 2, 3",
                "3 - 2, 1",
                "2 * 3, 6",
                "6 / 3, 2",
                "6 / (1 + 2) , 2",
                "50%, 0.5",
                "100 * 30%, 30.0",
                "1 + 2 * (3 - 4) / 5, 100"
        };
        for (String source : sources) {
            String input = source.split(",")[0].trim();
            BigDecimal result = new BigDecimal(source.split(",")[1].trim());
            System.out.println(calculate(input) + " -> " + result);
        }
    }

    private static BigDecimal calculate(String expression) {
        CharStream cs = CharStreams.fromString(expression);
        CalcLexer lexer = new CalcLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        CalcParser.CalcContext context = parser.calc();
        CalculateVisitor visitor = new CalculateVisitor();
        return visitor.visit(context);
    }

}