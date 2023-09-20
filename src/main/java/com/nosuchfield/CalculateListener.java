package com.nosuchfield;

import com.nosuchfield.antlr4.CalcBaseListener;
import com.nosuchfield.antlr4.CalcLexer;
import com.nosuchfield.antlr4.CalcParser;
import org.antlr.v4.runtime.Token;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
import java.util.Stack;

public class CalculateListener extends CalcBaseListener {

    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    private Stack<BigDecimal> stack;

    private BigDecimal result;

    @Override
    public void enterCalculationBlock(CalcParser.CalculationBlockContext ctx) {
        // 创建新的栈
        stack = new Stack<>();
    }

    @Override
    public void exitCalculationBlock(CalcParser.CalculationBlockContext ctx) {
        // 取出栈顶元素作为结果
        result = stack.pop();
    }

    @Override
    public void exitExpressionMulOrDiv(CalcParser.ExpressionMulOrDivContext ctx) {
        // 将栈顶的两个元素取出来做乘除法，将结果压回栈
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        BigDecimal z;
        switch (ctx.op.getType()) {
            case CalcLexer.MUL:
                z = y.multiply(x, MATH_CONTEXT);
                break;
            case CalcLexer.DIV:
                z = y.divide(x, MATH_CONTEXT);
                break;
            default:
                throw new RuntimeException("unsupported operator type");
        }
        stack.push(z);
    }

    @Override
    public void exitExpressionAddOrSub(CalcParser.ExpressionAddOrSubContext ctx) {
        // 将栈顶两个元素取出来做加减法，将结果压回栈
        BigDecimal x = stack.pop();
        BigDecimal y = stack.pop();
        BigDecimal z;
        switch (ctx.op.getType()) {
            case CalcLexer.ADD:
                z = y.add(x, MATH_CONTEXT);
                break;
            case CalcLexer.SUB:
                z = y.subtract(x, MATH_CONTEXT);
                break;
            default:
                throw new RuntimeException("unsupported operator type");
        }
        stack.push(z);
    }

    @Override
    public void exitExpressionNumeric(CalcParser.ExpressionNumericContext ctx) {
        // 计算数字
        BigDecimal numeric = numberOrPercent(ctx.num);
        if (Objects.nonNull(ctx.sign) && ctx.sign.getType() == CalcLexer.SUB) {
            numeric = numeric.negate();
        }
        stack.push(numeric);
    }

    private BigDecimal numberOrPercent(Token num) {
        String numberStr = num.getText();
        switch (num.getType()) {
            case CalcLexer.NUMBER:
                return new BigDecimal(numberStr);
            case CalcLexer.PERCENT_NUMBER:
                return new BigDecimal(numberStr.substring(0, numberStr.length() - 1).trim())
                        .divide(BigDecimal.valueOf(100), MATH_CONTEXT);
            default:
                throw new RuntimeException("unsupported number type");
        }
    }

    /**
     * 获取计算结果
     *
     * @return 计算结果
     */
    public BigDecimal getResult() {
        return result;
    }

}
