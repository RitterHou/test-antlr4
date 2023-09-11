package com.nosuchfield;

import com.nosuchfield.antlr4.CalcLexer;
import com.nosuchfield.antlr4.CalcParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class TestCalculate {

    @Test
    public void testCalculate() {
        String[][] sources = new String[][]{
                {"1 + 2", "3"},
                {"3 - 2", "1"},
                {"2 * 3", "6"},
                {"6 / 3", "2"},
                {"6 / (1 + 2)", "2"},
                {"50%", "0.5"},
                {"100 * 30%", "30.0"},
                {"1 + 2 * (3 - 4) / 5", "0.6"},
                {"-8 + 8 * 2 - 8", "0"}
        };
        for (String[] source : sources) {
            String input = source[0].trim();
            BigDecimal result = new BigDecimal(source[1].trim());
            assertEquals(calculate(input), result);
        }
    }

    /**
     * 计算表达式
     *
     * @param expression 表达式
     * @return 计算的结果
     */
    private BigDecimal calculate(String expression) {
        CharStream cs = CharStreams.fromString(expression);
        CalcLexer lexer = new CalcLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        CalcParser.CalcContext context = parser.calc();
        CalculateVisitor visitor = new CalculateVisitor();
        return visitor.visit(context);
    }

}