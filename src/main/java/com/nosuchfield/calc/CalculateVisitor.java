package com.nosuchfield.calc;

import com.nosuchfield.calc.code.CalcBaseVisitor;
import com.nosuchfield.calc.code.CalcLexer;
import com.nosuchfield.calc.code.CalcParser;
import org.antlr.v4.runtime.Token;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class CalculateVisitor extends CalcBaseVisitor<BigDecimal> {

    /**
     * 用于设置BigDecimal的计算精度
     */
    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    /**
     * calc语法，包含了多个expr，返回最后一个expr的结果
     */
    @Override
    public BigDecimal visitCalculationBlock(CalcParser.CalculationBlockContext ctx) {
        BigDecimal calcResult = null;
        for (CalcParser.ExprContext expr : ctx.expr()) {
            calcResult = visit(expr);
        }
        return calcResult;
    }

    /**
     * 左右括号，取出括号中的表达式
     */
    @Override
    public BigDecimal visitExpressionWithBr(CalcParser.ExpressionWithBrContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * 乘除法，返回左右两个元素的计算结果
     * 其中op属性是在语法文件中自定义的
     */
    @Override
    public BigDecimal visitExpressionMulOrDiv(CalcParser.ExpressionMulOrDivContext ctx) {
        BigDecimal left = visit(ctx.expr(0));
        BigDecimal right = visit(ctx.expr(1));
        switch (ctx.op.getType()) {
            case CalcParser.MUL:
                return left.multiply(right, MATH_CONTEXT);
            case CalcParser.DIV:
                return left.divide(right, MATH_CONTEXT);
            default:
                throw new RuntimeException("unsupported operator type");
        }
    }

    /**
     * 加减法，返回左右两个元素的计算结果
     * 其中op属性是在语法文件中自定义的
     */
    @Override
    public BigDecimal visitExpressionAddOrSub(CalcParser.ExpressionAddOrSubContext ctx) {
        BigDecimal left = visit(ctx.expr(0));
        BigDecimal right = visit(ctx.expr(1));
        switch (ctx.op.getType()) {
            case CalcParser.ADD:
                return left.add(right, MATH_CONTEXT);
            case CalcParser.SUB:
                return left.subtract(right, MATH_CONTEXT);
            default:
                throw new RuntimeException("unsupported operator type");
        }
    }

    /**
     * 获取数值，num属性是在语法文件中定义的
     * 如果数值前有负号就取负值
     */
    @Override
    public BigDecimal visitExpressionNumeric(CalcParser.ExpressionNumericContext ctx) {
        BigDecimal numeric = numberOrPercent(ctx.num);
        if (Objects.nonNull(ctx.sign) && ctx.sign.getType() == CalcLexer.SUB) {
            return numeric.negate();
        }
        return numeric;
    }

    /**
     * 将文本内容转化为BigDecimal，包含数字和百分数
     */
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

}
