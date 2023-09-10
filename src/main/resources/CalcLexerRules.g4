lexer grammar CalcLexerRules;

PERCENT_NUMBER: NUMBER PERCENT; // 百分数
NUMBER: DIGIT (POINT DIGIT)?;   // 小数

DIGIT: [0-9]+;  // 数字
BRACKET_L: '('; // 左括号
BRACKET_R: ')'; // 右括号
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
PERCENT: '%';
POINT: '.';

WS: [ \t\r\n]+ -> skip; // 跳过空格换行等字符
