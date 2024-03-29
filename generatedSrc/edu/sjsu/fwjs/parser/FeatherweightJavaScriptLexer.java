// Generated from FeatherweightJavaScript.g4 by ANTLR 4.7.2
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FeatherweightJavaScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, IF=7, ELSE=8, WHILE=9, 
		FUNCTION=10, VAR=11, PRINT=12, INT=13, BOOL=14, NULL=15, ID=16, MUL=17, 
		DIV=18, ADD=19, SUB=20, MOD=21, GT=22, LT=23, GE=24, LE=25, EQ=26, SEPARATOR=27, 
		NEWLINE=28, LINE_COMMENT=29, BLOCK_COMMENT=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "IF", "ELSE", "WHILE", 
			"FUNCTION", "VAR", "PRINT", "INT", "BOOL", "NULL", "ID", "MUL", "DIV", 
			"ADD", "SUB", "MOD", "GT", "LT", "GE", "LE", "EQ", "SEPARATOR", "NEWLINE", 
			"LINE_COMMENT", "BLOCK_COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "','", "'{'", "'}'", "'if'", "'else'", "'while'", 
			"'function'", "'var'", "'print'", null, null, "'null'", null, "'*'", 
			"'/'", "'+'", "'-'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "IF", "ELSE", "WHILE", "FUNCTION", 
			"VAR", "PRINT", "INT", "BOOL", "NULL", "ID", "MUL", "DIV", "ADD", "SUB", 
			"MOD", "GT", "LT", "GE", "LE", "EQ", "SEPARATOR", "NEWLINE", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FeatherweightJavaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FeatherweightJavaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00cf\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16q\n\16\f\16"+
		"\16\16t\13\16\3\16\5\16w\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u0082\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u008b\n"+
		"\21\f\21\16\21\u008e\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\5\35\u00aa\n\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\7\36\u00b4\n\36\f\36\16\36\u00b7\13\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\7\37\u00bf\n\37\f\37\16\37\u00c2\13\37\3\37\3\37\3\37\3\37\3\37\3 \6"+
		" \u00ca\n \r \16 \u00cb\3 \3 \3\u00c0\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\b\3\2\63;\3\2\62;\5\2"+
		"C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\4\2\13\13\"\"\2\u00d6\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2"+
		"\2\rK\3\2\2\2\17M\3\2\2\2\21P\3\2\2\2\23U\3\2\2\2\25[\3\2\2\2\27d\3\2"+
		"\2\2\31h\3\2\2\2\33v\3\2\2\2\35\u0081\3\2\2\2\37\u0083\3\2\2\2!\u0088"+
		"\3\2\2\2#\u008f\3\2\2\2%\u0091\3\2\2\2\'\u0093\3\2\2\2)\u0095\3\2\2\2"+
		"+\u0097\3\2\2\2-\u0099\3\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2\63\u00a0"+
		"\3\2\2\2\65\u00a3\3\2\2\2\67\u00a6\3\2\2\29\u00a9\3\2\2\2;\u00af\3\2\2"+
		"\2=\u00ba\3\2\2\2?\u00c9\3\2\2\2AB\7*\2\2B\4\3\2\2\2CD\7+\2\2D\6\3\2\2"+
		"\2EF\7?\2\2F\b\3\2\2\2GH\7.\2\2H\n\3\2\2\2IJ\7}\2\2J\f\3\2\2\2KL\7\177"+
		"\2\2L\16\3\2\2\2MN\7k\2\2NO\7h\2\2O\20\3\2\2\2PQ\7g\2\2QR\7n\2\2RS\7u"+
		"\2\2ST\7g\2\2T\22\3\2\2\2UV\7y\2\2VW\7j\2\2WX\7k\2\2XY\7n\2\2YZ\7g\2\2"+
		"Z\24\3\2\2\2[\\\7h\2\2\\]\7w\2\2]^\7p\2\2^_\7e\2\2_`\7v\2\2`a\7k\2\2a"+
		"b\7q\2\2bc\7p\2\2c\26\3\2\2\2de\7x\2\2ef\7c\2\2fg\7t\2\2g\30\3\2\2\2h"+
		"i\7r\2\2ij\7t\2\2jk\7k\2\2kl\7p\2\2lm\7v\2\2m\32\3\2\2\2nr\t\2\2\2oq\t"+
		"\3\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sw\3\2\2\2tr\3\2\2\2uw\7"+
		"\62\2\2vn\3\2\2\2vu\3\2\2\2w\34\3\2\2\2xy\7v\2\2yz\7t\2\2z{\7w\2\2{\u0082"+
		"\7g\2\2|}\7h\2\2}~\7c\2\2~\177\7n\2\2\177\u0080\7u\2\2\u0080\u0082\7g"+
		"\2\2\u0081x\3\2\2\2\u0081|\3\2\2\2\u0082\36\3\2\2\2\u0083\u0084\7p\2\2"+
		"\u0084\u0085\7w\2\2\u0085\u0086\7n\2\2\u0086\u0087\7n\2\2\u0087 \3\2\2"+
		"\2\u0088\u008c\t\4\2\2\u0089\u008b\t\5\2\2\u008a\u0089\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\"\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0090\7,\2\2\u0090$\3\2\2\2\u0091\u0092\7\61\2\2"+
		"\u0092&\3\2\2\2\u0093\u0094\7-\2\2\u0094(\3\2\2\2\u0095\u0096\7/\2\2\u0096"+
		"*\3\2\2\2\u0097\u0098\7\'\2\2\u0098,\3\2\2\2\u0099\u009a\7@\2\2\u009a"+
		".\3\2\2\2\u009b\u009c\7>\2\2\u009c\60\3\2\2\2\u009d\u009e\7@\2\2\u009e"+
		"\u009f\7?\2\2\u009f\62\3\2\2\2\u00a0\u00a1\7>\2\2\u00a1\u00a2\7?\2\2\u00a2"+
		"\64\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4\u00a5\7?\2\2\u00a5\66\3\2\2\2\u00a6"+
		"\u00a7\7=\2\2\u00a78\3\2\2\2\u00a8\u00aa\7\17\2\2\u00a9\u00a8\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\b\35\2\2\u00ae:\3\2\2\2\u00af\u00b0\7\61\2\2\u00b0"+
		"\u00b1\7\61\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b4\n\6\2\2\u00b3\u00b2\3"+
		"\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\b\36\2\2\u00b9<\3\2\2\2"+
		"\u00ba\u00bb\7\61\2\2\u00bb\u00bc\7,\2\2\u00bc\u00c0\3\2\2\2\u00bd\u00bf"+
		"\13\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00c1\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4"+
		"\7,\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\37\2\2"+
		"\u00c7>\3\2\2\2\u00c8\u00ca\t\7\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\b \2\2\u00ce@\3\2\2\2\13\2rv\u0081\u008c\u00a9\u00b5\u00c0\u00cb"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}