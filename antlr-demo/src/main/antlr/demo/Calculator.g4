grammar Calculator;

prog: (expr)*;

expr: '-'NUMBER                 #UnaryMinus
    | expr (MUL|DIV) expr       #MulDiv
    | expr (ADD|SUB) expr       #AddSum
    | NUMBER                    #Const
    | '(' expr ')'              #NestedExpr
    ;
NUMBER : [0-9]+ ;

MUL :'*'
    ;

DIV : '/'
    ;

ADD : '+'
    ;

SUB : '-'
    ;

WS  : [ \r\t\n]+ ->skip;
