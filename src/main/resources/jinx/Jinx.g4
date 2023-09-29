grammar Jinx;

@header {
package com.nosuchfield.jinx.code;
}

jinx: CLASS ID LEFT_BR classBody RIGHT_BR EOF;
classBody: (variable | print | functionDeclaration | functionCall)*;
functionDeclaration: FUNCTION ID LEFT_ROUND_BR functionParams RIGHT_ROUND_BR LEFT_BR functionBody RIGHT_BR;
functionParams:  | ID (COMMA ID)*;
functionBody: (variable | print | functionCall)*;
functionCall: ID LEFT_ROUND_BR functionParams RIGHT_ROUND_BR;
variable: VARIABLE ID EQUALS value;
print: PRINT ID;
value: STRING | INT | DOUBLE;

LEFT_BR: '{';
RIGHT_BR: '}';
LEFT_ROUND_BR: '(';
RIGHT_ROUND_BR: ')';
FUNCTION: 'func';
CLASS: 'class';
VARIABLE: 'var';
PRINT: 'print';
EQUALS: '=';
COMMA: ',';
STRING: '"' ('\\"' | ~'"')+ '"' | '""';
DOUBLE: [0-9]+ '.' [0-9]+;
INT: [0-9]+;
// 这个ID不能放在前面，不然会被提前解析，导致print等字符串被解析为ID
ID: [a-zA-Z] [a-zA-Z0-9]*;

WS: [\n\r\t ]+ -> skip;
