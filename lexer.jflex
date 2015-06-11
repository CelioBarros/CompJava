package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Number     = [0-9]+

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*
DocumentationComment = "/*" "*"+ [^/*] ~"*/"


ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  {Whitespace} {                              }
  "<<"         { return symbolFactory.newSymbol("LSHIFT", LSHIFT); }
  ">>"         { return symbolFactory.newSymbol("RSHIFT", RSHIFT); }
  ">>="        { return symbolFactory.newSymbol("RSHIFTEQ", RSHIFTEQ); }
  ">>>"        { return symbolFactory.newSymbol("SSHIFT", SSHIFT); }
  "~"          { return symbolFactory.newSymbol("COMP", COMP); }
  ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
  "."          { return symbolFactory.newSymbol("POINT", POINT); }
  "*"          { return symbolFactory.newSymbol("MULT", MULT); }
  ","          { return symbolFactory.newSymbol("COMMA", COMMA); }
  "("          { return symbolFactory.newSymbol("LPAREN", LPAREN); }
  ")"          { return symbolFactory.newSymbol("RPAREN", RPAREN); }
  "{"          { return symbolFactory.newSymbol("LBRACE", LBRACE); }
  "}"          { return symbolFactory.newSymbol("RBRACE", RBRACE); }
  "["          { return symbolFactory.newSymbol("LBRACK", LBRACK); }
  "]"          { return symbolFactory.newSymbol("RBRACK", RBRACK); }
  "="          { return symbolFactory.newSymbol("EQ", EQ); }
  "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
  "--"         { return symbolFactory.newSymbol("MINUSMINUS", MINUSMINUS); }
  "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
  "++"         { return symbolFactory.newSymbol("PLUSPLUS", PLUSPLUS); }
  "+="         { return symbolFactory.newSymbol("PLUSEQ", PLUSEQ); }
  "-="         { return symbolFactory.newSymbol("MINUSEQ", MINUSEQ); }
  "*="         { return symbolFactory.newSymbol("MULTEQ", MULTEQ); }
  "/"          { return symbolFactory.newSymbol("DIV", DIV); }
  "/="         { return symbolFactory.newSymbol("DIVEQ", DIVEQ); }
  "%"          { return symbolFactory.newSymbol("MOD", MOD); }
  "%="         { return symbolFactory.newSymbol("MODEQ", MODEQ); }
  ">"          { return symbolFactory.newSymbol("GT", GT); }
  "<"          { return symbolFactory.newSymbol("LT", LT); }
  ">="         { return symbolFactory.newSymbol("GTEQ", GTEQ); }
  "<="         { return symbolFactory.newSymbol("LTEQ", LTEQ); }
  "=="         { return symbolFactory.newSymbol("EQEQ", EQEQ); }
  "!="         { return symbolFactory.newSymbol("NOTEQ", NOTEQ); }
  "!"          { return symbolFactory.newSymbol("NOT", NOT); }
  "?"          { return symbolFactory.newSymbol("QUESTION", QUESTION); }
  ":"          { return symbolFactory.newSymbol("COLON", COLON); }
  "|"          { return symbolFactory.newSymbol("OR", OR); }
  "||"         { return symbolFactory.newSymbol("OROR", OROR); }
  "|="         { return symbolFactory.newSymbol("OREQ", OREQ); }
  "||="        { return symbolFactory.newSymbol("OROREQ", OROREQ); }
  "^"          { return symbolFactory.newSymbol("XOR", XOR); }
  "^="         { return symbolFactory.newSymbol("XOREQ", XOREQ); }
  "new"        { return symbolFactory.newSymbol("NEW", NEW); }
  "package"    { return symbolFactory.newSymbol("PACKAGE", PACKAGE); }
  "import"     { return symbolFactory.newSymbol("IMPORT", IMPORT); }
  "class"      { return symbolFactory.newSymbol("CLASS", CLASS); }
  "public"     { return symbolFactory.newSymbol("PUBLIC", PUBLIC); }
  "protected"  { return symbolFactory.newSymbol("PROTECTED", PROTECTED); }
  "private"    { return symbolFactory.newSymbol("PRIVATE", PRIVATE); }
  "static"     { return symbolFactory.newSymbol("STATIC", STATIC); }
  "abstract"   { return symbolFactory.newSymbol("ABSTRACT", ABSTRACT); }
  "final"      { return symbolFactory.newSymbol("FINAL", FINAL); }
  "native"     { return symbolFactory.newSymbol("NATIVE", NATIVE); }
  "synchronized"     { return symbolFactory.newSymbol("SYNCHRONIZED", SYNCHRONIZED); }
  "transient"  { return symbolFactory.newSymbol("TRANSIENT", TRANSIENT); }
  "volatile"   { return symbolFactory.newSymbol("VOLATILE", VOLATILE); }
  "extends"    { return symbolFactory.newSymbol("EXTENDS", EXTENDS); }
  "implements" { return symbolFactory.newSymbol("IMPLEMENTS", IMPLEMENTS); }
  "boolean"    { return symbolFactory.newSymbol("BOOLEAN", BOOLEAN); }
  "byte"       { return symbolFactory.newSymbol("BYTE", BYTE); } 
  "char"       { return symbolFactory.newSymbol("CHAR", CHAR); }
  "short"      { return symbolFactory.newSymbol("SHORT", SHORT); } 
  "int"        { return symbolFactory.newSymbol("INT", INT); }
  "float"      { return symbolFactory.newSymbol("FLOAT", FLOAT); } 
  "long"       { return symbolFactory.newSymbol("LONG", LONG); } 
  "true"       { return symbolFactory.newSymbol("TRUE", TRUE); }
  "false"      { return symbolFactory.newSymbol("FALSE", FALSE); }
  "ampersand"  { return symbolFactory.newSymbol("AMPERSAND", AMPERSAND); }
  "ampersand=" { return symbolFactory.newSymbol("AMPERSANDEQ", AMPERSANDEQ); }
  {Comment}    { /* ignore */ }
  {ident}      { return symbolFactory.newSymbol("IDENTIFIER", IDENTIFIER, yytext().toString()); }
}



// error fallback

/* error fallback */
{Number}{ident} { throw new RuntimeException("Variável não pode começar com número em \""+yytext()+
                                                             "\" na linha "+yyline+", coluna "+yycolumn); }
[^]|\n                             { throw new RuntimeException("Caractere inválido \""+yytext()+
                                                             "\" na linha "+yyline+", coluna "+yycolumn); }
