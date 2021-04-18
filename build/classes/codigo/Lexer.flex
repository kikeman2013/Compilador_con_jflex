package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
Cad=(\")(\s+|[ A-Za-z]|_|[0-9] | [:\.\\\?\¿\%\&] )*(\")
Char = (\')([A-Za-z]|_|[0-9]|\\s+)(\')
espacio=[ \t\r]+
%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return Linea;}

/* Tipos de datos */
( byte | int | char | long | float | double | string | bool ) {lexeme=yytext(); return T_dato;}

/* Cadena */
( {Cad} ) {lexeme=yytext(); return Cadena;}

/* Caracter */
( {Char} ) {lexeme=yytext(); return Char;}

/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}

/* Palabra reservada If */
( if ) {lexeme=yytext(); return If;}

/* Palabra reservada Else */
( else ) {lexeme=yytext(); return Else;}

/* Palabra reservada Do */
( do ) {lexeme=yytext(); return Do;}

/* Palabra reservada While */
( while ) {lexeme=yytext(); return While;}

/* Palabra reservada For */
( for ) {lexeme=yytext(); return For;}

/* Operador Igual */
( "=" ) {lexeme=yytext(); return Igual;}


/* Operador Suma */
( "+" ) {lexeme=yytext(); return Suma;}

/* Operador Resta */
( "-" ) {lexeme=yytext(); return Resta;}

/* Operador Multiplicacion */
( "*" ) {lexeme=yytext(); return Multiplicacion;}

/* Operador Division */
( "/" ) {lexeme=yytext(); return Division;}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return Op_relacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}

/*Operadores Booleanos*/
(true | false)      {lexeme = yytext(); return Op_booleano;}

/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return Parentesis_c;}

/* Llave de apertura */
( "{" ) {lexeme=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexeme=yytext(); return Llave_c;}

/* Corchete de apertura */
( "[" ) {lexeme = yytext(); return Corchete_a;}

/* Corchete de cierre */
( "]" ) {lexeme = yytext(); return Corchete_c;}

/* Marcador de inicio de algoritmo */
( "main" ) {lexeme=yytext(); return Main;}

/* Punto y coma */
( ";" ) {lexeme=yytext(); return P_coma;}

/* Numero */
("-"{D}+"")|{D}+ | {D}*"."{D}+ {lexeme=yytext(); return Numero;}

/* Palabra reservada Math */
( "Math.seno" | "Math.cos" | "Math.csc" | "Math.tan" | "Math.arctan" | "Math.arccos" | "Math.arcseno" ) {lexeme=yytext(); return Math;}

/* Coma */
( "," ) {lexeme=yytext(); return Coma;}

/* Raiz */
( "sqrt" ) {lexeme=yytext(); return Raiz;}

/* Potencia */
( "pow" ) {lexeme=yytext(); return Pow;}

/*Imprimir */
( "imprimir"|"printf") {lexeme=yytext(); return Imprimir;}

/*Ingresar */
( "ingresar"| "scanf") {lexeme=yytext(); return Ingresar;}

/* Void */
( void ) {lexeme=yytext(); return Void;}

/* Return */
( return ) {lexeme=yytext(); return Return;}

/* Mod*/
( "%") {lexeme=yytext(); return Mod;}

/* Potencia */
( "break" ) {lexeme=yytext(); return Break;}

/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* Error de analisis */
 . {return ERROR;}


