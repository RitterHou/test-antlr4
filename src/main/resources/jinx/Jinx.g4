grammar Jinx;

@header {
package com.nosuchfield.jinx.code;
}

jinx: (variable | print)* EOF;
variable: VARIABLE ID EQUALS value;
print: PRINT ID;
value: STRING | NUMBER;

VARIABLE: 'var';
PRINT: 'print';
EQUALS: '=';
STRING: '"' ('\\"' | ~'"')+ '"';
NUMBER: [0-9]+ ('.' [0-9]+)?;
// 这个ID不能放在前面，不然会被提前解析，导致print等字符串被解析为ID
ID: [a-zA-Z] [a-zA-Z0-9]*;

WS: [\n\r\t ]+ -> skip;

// 参考：http://jakubdziworski.github.io/enkel/2016/03/16/enkel_3_hello_enkel.html
