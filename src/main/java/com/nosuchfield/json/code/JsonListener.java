// Generated from D:/Projects/test-antlr4/src/main/resources/json\Json.g4 by ANTLR 4.12.0

package com.nosuchfield.json.code;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsonParser}.
 */
public interface JsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JsonParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(JsonParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(JsonParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(JsonParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(JsonParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(JsonParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(JsonParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#kv}.
	 * @param ctx the parse tree
	 */
	void enterKv(JsonParser.KvContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#kv}.
	 * @param ctx the parse tree
	 */
	void exitKv(JsonParser.KvContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value}
	 * labeled alternative in {@link JsonParser#v}.
	 * @param ctx the parse tree
	 */
	void enterValue(JsonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value}
	 * labeled alternative in {@link JsonParser#v}.
	 * @param ctx the parse tree
	 */
	void exitValue(JsonParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectValue}
	 * labeled alternative in {@link JsonParser#v}.
	 * @param ctx the parse tree
	 */
	void enterObjectValue(JsonParser.ObjectValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectValue}
	 * labeled alternative in {@link JsonParser#v}.
	 * @param ctx the parse tree
	 */
	void exitObjectValue(JsonParser.ObjectValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link JsonParser#v}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(JsonParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link JsonParser#v}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(JsonParser.ArrayValueContext ctx);
}