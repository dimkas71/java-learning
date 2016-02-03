grammar Calculator;

prog: (expr)*;

expr: expr (MUL|DIV) expr       #MulDiv
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
