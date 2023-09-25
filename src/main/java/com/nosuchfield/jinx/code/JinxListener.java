// Generated from D:/Projects/test-antlr4/src/main/resources/jinx/Jinx.g4 by ANTLR 4.13.1

package com.nosuchfield.jinx.code;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JinxParser}.
 */
public interface JinxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JinxParser#jinx}.
	 * @param ctx the parse tree
	 */
	void enterJinx(JinxParser.JinxContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinxParser#jinx}.
	 * @param ctx the parse tree
	 */
	void exitJinx(JinxParser.JinxContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JinxParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinxParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JinxParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinxParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(JinxParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinxParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(JinxParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinxParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(JinxParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinxParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(JinxParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinxParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(JinxParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinxParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(JinxParser.ValueContext ctx);
}