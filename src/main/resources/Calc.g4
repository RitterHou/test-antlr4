grammar Calc;
@header {
package com.nosuchfield.antlr4;
}
import CalcLexerRules; // 引入词法分析文件

calc: (expr)* EOF # calculationBlock;

expr:
	BRACKET_L expr BRACKET_R								# expressionWithBr
	| sign = (ADD | SUB)? num = (NUMBER | PERCENT_NUMBER)	# expressionNumeric
	| expr op = (MUL | DIV) expr							# expressionMulOrDiv
	| expr op = (ADD | SUB) expr							# expressionAddOrSub;
