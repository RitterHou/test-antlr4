// Generated from D:/Projects/test-antlr4/src/main/resources/calc\Calc.g4 by ANTLR 4.12.0

package com.nosuchfield.calc.code;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code calculationBlock}
	 * labeled alternative in {@link CalcParser#calc}.
	 * @param ctx the parse tree
	 */
	void enterCalculationBlock(CalcParser.CalculationBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calculationBlock}
	 * labeled alternative in {@link CalcParser#calc}.
	 * @param ctx the parse tree
	 */
	void exitCalculationBlock(CalcParser.CalculationBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionWithBr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionWithBr(CalcParser.ExpressionWithBrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionWithBr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionWithBr(CalcParser.ExpressionWithBrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionMulOrDiv}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMulOrDiv(CalcParser.ExpressionMulOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionMulOrDiv}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMulOrDiv(CalcParser.ExpressionMulOrDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAddOrSub}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddOrSub(CalcParser.ExpressionAddOrSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAddOrSub}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddOrSub(CalcParser.ExpressionAddOrSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumeric}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumeric(CalcParser.ExpressionNumericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumeric}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumeric(CalcParser.ExpressionNumericContext ctx);
}