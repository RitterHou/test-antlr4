// Generated from D:/Projects/test-antlr4/src/main/resources/calc\Calc.g4 by ANTLR 4.12.0

package com.nosuchfield.calc.code;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code calculationBlock}
	 * labeled alternative in {@link CalcParser#calc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculationBlock(CalcParser.CalculationBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionWithBr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithBr(CalcParser.ExpressionWithBrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionMulOrDiv}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMulOrDiv(CalcParser.ExpressionMulOrDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAddOrSub}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddOrSub(CalcParser.ExpressionAddOrSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumeric}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumeric(CalcParser.ExpressionNumericContext ctx);
}