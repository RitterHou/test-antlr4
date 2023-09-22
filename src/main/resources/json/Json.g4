grammar Json;

@header {
package com.nosuchfield.json.code;
}

json: (object | array) EOF;
object: '{' '}' | '{' kv (',' kv)* '}';
array: '[' ']' | '[' v (',' v)* ']';
kv: STRING ':' v;
v:
	STRING		# value
	| NUMBER	# value
	| object	# objectValue
	| array		# arrayValue
	| 'true'	# value
	| 'false'	# value
	| 'null'	# value;

STRING: '"' ~'"'+ '"';
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;

WS: [ \t\r\n]+ -> skip;
