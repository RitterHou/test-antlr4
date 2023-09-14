grammar Csv;

@header {
package org.example.antlr.csv.code;
}

csv: hdr row*;
hdr: row;
row: field (',' field)* '\r'? '\n';
field: TEXT # text | STRING # string | # empty;

TEXT: ~[\n,\r]+;
STRING: '"' ('""' | ~'"')* '"';
