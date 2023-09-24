grammar Jinx;

@header {
package com.nosuchfield.jinx.code;
}

jinx: CLASS ID LEFT_BR classBody RIGHT_BR EOF;
classBody: (variable | print)*;
variable: VARIABLE ID EQUALS value;
print: PRINT ID;
value: STRING | INT | DOUBLE;

LEFT_BR: '{';
RIGHT_BR: '}';
CLASS: 'class';
VARIABLE: 'var';
PRINT: 'print';
EQUALS: '=';
STRING: '"' ('\\"' | ~'"')+ '"';
DOUBLE: [0-9]+ '.' [0-9]+;
INT: [0-9]+;
// 这个ID不能放在前面，不然会被提前解析，导致print等字符串被解析为ID
ID: [a-zA-Z] [a-zA-Z0-9]*;

WS: [\n\r\t ]+ -> skip;
