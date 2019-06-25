grammar FeatherweightJavaScript;

@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE     : 'while' ;
FUNCTION  : 'function' ;
VAR       : 'var' ;
PRINT     : 'print' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL      : 'true' | 'false' ;
NULL      : 'null' ;
ID        : [a-zA-Z_][a-zA-Z_0-9]*;

// Symbols
MUL       : '*' ;
DIV       : '/' ;
ADD       : '+' ;
SUB       : '-' ;
MOD       : '%' ;
GT        : '>' ;
LT        : '<' ;
GE        : '>=' ;
LE        : '<=' ;
EQ        : '==' ;
SEPARATOR : ';' ;

// Whitespace and comments
NEWLINE   : '\r'? '\n' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace

// ***Paring rules ***

/** The start rule */
prog: stat+ ;                                           

stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
    | WHILE '(' expr ')' block                          # while
    | PRINT '(' expr ')' SEPARATOR?                     # print
    | SEPARATOR                                         # empty  
    ;
    
expr: expr op=( '*' | '/' | '%' ) expr                              # MulDivMod
	| expr op=( '+' | '-' ) expr 						            # AddSub
	| expr op=( '<' | '<=' | '>' | '>=' | '==' ) expr 	            # Comparison
    | FUNCTION params block                                         # FunctionDeclaration
    | expr args                                                     # FunctionApplication
    | VAR ID '=' expr                                               # VariableDeclaration
    | ID '=' expr                                                   # Assignment
    | ID                                                            # VariableReference
    | INT                                                           # Int
    | BOOL                                                          # Bool
    | NULL                                                          # Null
    | '(' expr ')'                                                  # Parens
    ;

params: '(' (ID (',' ID)* )? ')' ;

args: '(' (expr (',' expr)* )? ')' ;  

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;