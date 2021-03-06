
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20141204 (SVN rev 60)
//----------------------------------------------------

package cup.example;

/** CUP generated interface containing symbol constants. */
public interface sym {
  /* terminals */
  public static final int SHORT = 68;
  public static final int IDENTIFIER = 97;
  public static final int GT = 38;
  public static final int IMPLEMENTS = 10;
  public static final int SSHIFT = 51;
  public static final int NOTEQ = 43;
  public static final int PLUSEQ = 32;
  public static final int SEMI = 2;
  public static final int RBRACK = 24;
  public static final int CATCH = 91;
  public static final int COMMA = 5;
  public static final int RBRACE = 22;
  public static final int THROW = 45;
  public static final int RPAREN = 54;
  public static final int LBRACK = 23;
  public static final int LT = 39;
  public static final int OROR = 63;
  public static final int DOUBLE = 72;
  public static final int LBRACE = 21;
  public static final int TRANSIENT = 19;
  public static final int LPAREN = 53;
  public static final int INTEGER_LITERAL_LONG = 75;
  public static final int XOREQ = 73;
  public static final int PROTECTED = 12;
  public static final int INTEGER_LITERAL = 100;
  public static final int FALSE = 57;
  public static final int NOT = 28;
  public static final int FINAL = 16;
  public static final int FLOAT = 70;
  public static final int PACKAGE = 3;
  public static final int COMP = 48;
  public static final int EQ = 25;
  public static final int OCT_LITERAL_LONG = 79;
  public static final int MOD = 26;
  public static final int AMPERSANDEQ = 61;
  public static final int CLASS = 8;
  public static final int SUPER = 82;
  public static final int ABSTRACT = 15;
  public static final int TRUE = 56;
  public static final int NATIVE = 17;
  public static final int LONG = 71;
  public static final int PLUS = 37;
  public static final int QUESTION = 58;
  public static final int WHILE = 88;
  public static final int EXTENDS = 9;
  public static final int INTERFACE = 96;
  public static final int CHAR = 67;
  public static final int BOOLEAN = 101;
  public static final int SWITCH = 93;
  public static final int FOR = 89;
  public static final int DO = 87;
  public static final int RSHIFTEQ = 49;
  public static final int DIV = 35;
  public static final int PUBLIC = 11;
  public static final int RETURN = 44;
  public static final int MULT = 7;
  public static final int TRY = 90;
  public static final int ELSE = 86;
  public static final int POINT = 4;
  public static final int BREAK = 46;
  public static final int GTEQ = 40;
  public static final int AMPERSAND = 60;
  public static final int INT = 69;
  public static final int STRING_LITERAL = 99;
  public static final int OCT_LITERAL = 78;
  public static final int NULL = 81;
  public static final int EQEQ = 42;
  public static final int EOF = 0;
  public static final int THIS = 83;
  public static final int DEFAULT = 95;
  public static final int MULTEQ = 34;
  public static final int IMPORT = 6;
  public static final int OROREQ = 65;
  public static final int MINUS = 29;
  public static final int FLOAT_LITERAL = 80;
  public static final int LTEQ = 41;
  public static final int OR = 62;
  public static final int error = 1;
  public static final int SYNCHRONIZED = 18;
  public static final int DIVEQ = 36;
  public static final int FINALLY = 92;
  public static final int CONTINUE = 47;
  public static final int IF = 85;
  public static final int INSTANCEOF = 84;
  public static final int MODEQ = 27;
  public static final int MINUSMINUS = 30;
  public static final int COLON = 59;
  public static final int HEX_LITERAL = 76;
  public static final int CHARACTER_LITERAL = 98;
  public static final int VOLATILE = 20;
  public static final int OREQ = 64;
  public static final int CASE = 94;
  public static final int PLUSPLUS = 31;
  public static final int HEX_LITERAL_LONG = 77;
  public static final int NEW = 55;
  public static final int RSHIFT = 50;
  public static final int BYTE = 66;
  public static final int PRIVATE = 13;
  public static final int STATIC = 14;
  public static final int LSHIFT = 52;
  public static final int XOR = 74;
  public static final int MINUSEQ = 33;
  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "SEMI",
  "PACKAGE",
  "POINT",
  "COMMA",
  "IMPORT",
  "MULT",
  "CLASS",
  "EXTENDS",
  "IMPLEMENTS",
  "PUBLIC",
  "PROTECTED",
  "PRIVATE",
  "STATIC",
  "ABSTRACT",
  "FINAL",
  "NATIVE",
  "SYNCHRONIZED",
  "TRANSIENT",
  "VOLATILE",
  "LBRACE",
  "RBRACE",
  "LBRACK",
  "RBRACK",
  "EQ",
  "MOD",
  "MODEQ",
  "NOT",
  "MINUS",
  "MINUSMINUS",
  "PLUSPLUS",
  "PLUSEQ",
  "MINUSEQ",
  "MULTEQ",
  "DIV",
  "DIVEQ",
  "PLUS",
  "GT",
  "LT",
  "GTEQ",
  "LTEQ",
  "EQEQ",
  "NOTEQ",
  "RETURN",
  "THROW",
  "BREAK",
  "CONTINUE",
  "COMP",
  "RSHIFTEQ",
  "RSHIFT",
  "SSHIFT",
  "LSHIFT",
  "LPAREN",
  "RPAREN",
  "NEW",
  "TRUE",
  "FALSE",
  "QUESTION",
  "COLON",
  "AMPERSAND",
  "AMPERSANDEQ",
  "OR",
  "OROR",
  "OREQ",
  "OROREQ",
  "BYTE",
  "CHAR",
  "SHORT",
  "INT",
  "FLOAT",
  "LONG",
  "DOUBLE",
  "XOREQ",
  "XOR",
  "INTEGER_LITERAL_LONG",
  "HEX_LITERAL",
  "HEX_LITERAL_LONG",
  "OCT_LITERAL",
  "OCT_LITERAL_LONG",
  "FLOAT_LITERAL",
  "NULL",
  "SUPER",
  "THIS",
  "INSTANCEOF",
  "IF",
  "ELSE",
  "DO",
  "WHILE",
  "FOR",
  "TRY",
  "CATCH",
  "FINALLY",
  "SWITCH",
  "CASE",
  "DEFAULT",
  "INTERFACE",
  "IDENTIFIER",
  "CHARACTER_LITERAL",
  "STRING_LITERAL",
  "INTEGER_LITERAL",
  "BOOLEAN"
  };
}

