package MyGCC;
import java_cup.runtime.SymbolFactory;

%%

%cup
%class Scanner
%{
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
	}
	private SymbolFactory sf;
%}

%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}

ALPHA = [a-zA-Z_]
ALPHA_NUM = {ALPHA}|[0-9]
IDENT = {ALPHA}({ALPHA_NUM})*

%%

"=="		{return sf.newSymbol("Equals",sym.EQUALS); }
"!="		{return sf.newSymbol("Different",sym.DIFF); }
"<="		{return sf.newSymbol("Less or equal",sym.LEQL); }
">="		{return sf.newSymbol("Greater or equal",sym.GEQL); }
"||"		{return sf.newSymbol("Binary Or",sym.OR); }
"&&"		{return sf.newSymbol("Binary And",sym.AND); }

","			{return sf.newSymbol("Comma",sym.COMMA); }
";"			{return sf.newSymbol("Semicolon",sym.SEMI); }
"+"			{return sf.newSymbol("Plus",sym.PLUS); }
"*"			{return sf.newSymbol("Times",sym.TIMES); }
"-"			{return sf.newSymbol("Minus",sym.MINUS); }
"/"			{return sf.newSymbol("Divided",sym.DIV); }
"%"			{return sf.newSymbol("Modulo",sym.MOD); }
"="			{return sf.newSymbol("Affectation", sym.EQL); }
"!"			{return sf.newSymbol("Not",sym.NOT); }
"<"			{return sf.newSymbol("Less",sym.LESS); }
">"			{return sf.newSymbol("Greater",sym.GREATER); }

"("			{return sf.newSymbol("Left Parenthesis",sym.LPAREN); }
")"			{return sf.newSymbol("Right Parenthesis",sym.RPAREN); }
"["			{return sf.newSymbol("Left Hook",sym.LHOOK); }
"]"			{return sf.newSymbol("Right Hook",sym.RHOOK); }
"{"			{return sf.newSymbol("Left Bracket",sym.LBRACKET); }
"}"			{return sf.newSymbol("Right Bracket",sym.RBRACKET); }

"if"		{return sf.newSymbol("If statement",sym.IF); }
"else"		{return sf.newSymbol("Else statement",sym.ELSE); }
"int"		{return sf.newSymbol("Int type", sym.INT); }
"void"		{return sf.newSymbol("Void type", sym.VOID); }
"static"	{return sf.newSymbol("Static type", sym.STATIC); }
"exit"		{return sf.newSymbol("Exit instruction", sym.EXIT); }
"return"	{return sf.newSymbol("Return instruction", sym.RETURN); }

{IDENT}		{return sf.newSymbol("Identificator", sym.IDENT); }

[0-9]+ 		{return sf.newSymbol("Integral Number",sym.NB_INT, new Integer(yytext())); }

[ \t\r\n\f] { /* ignore white space. */ }
. 			{ System.err.println("Illegal character: "+yytext()); }
