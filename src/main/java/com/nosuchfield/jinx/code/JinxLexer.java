// Generated from D:/Projects/test-antlr4/src/main/resources/jinx/Jinx.g4 by ANTLR 4.13.1

package com.nosuchfield.jinx.code;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JinxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_BR=1, RIGHT_BR=2, LEFT_ROUND_BR=3, RIGHT_ROUND_BR=4, FUNCTION=5, 
		CLASS=6, VARIABLE=7, PRINT=8, EQUALS=9, COMMA=10, STRING=11, DOUBLE=12, 
		INT=13, ID=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LEFT_BR", "RIGHT_BR", "LEFT_ROUND_BR", "RIGHT_ROUND_BR", "FUNCTION", 
			"CLASS", "VARIABLE", "PRINT", "EQUALS", "COMMA", "STRING", "DOUBLE", 
			"INT", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'func'", "'class'", "'var'", "'print'", 
			"'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEFT_BR", "RIGHT_BR", "LEFT_ROUND_BR", "RIGHT_ROUND_BR", "FUNCTION", 
			"CLASS", "VARIABLE", "PRINT", "EQUALS", "COMMA", "STRING", "DOUBLE", 
			"INT", "ID", "WS"
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


	public JinxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Jinx.g4"; }

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
		"\u0004\u0000\u000fh\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0004\nE\b\n\u000b\n"+
		"\f\nF\u0001\n\u0001\n\u0001\u000b\u0004\u000bL\b\u000b\u000b\u000b\f\u000b"+
		"M\u0001\u000b\u0001\u000b\u0004\u000bR\b\u000b\u000b\u000b\f\u000bS\u0001"+
		"\f\u0004\fW\b\f\u000b\f\f\fX\u0001\r\u0001\r\u0005\r]\b\r\n\r\f\r`\t\r"+
		"\u0001\u000e\u0004\u000ec\b\u000e\u000b\u000e\f\u000ed\u0001\u000e\u0001"+
		"\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0005\u0001\u0000\"\"\u0001"+
		"\u000009\u0002\u0000AZaz\u0003\u000009AZaz\u0003\u0000\t\n\r\r  n\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000\u0003!\u0001"+
		"\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007%\u0001\u0000\u0000"+
		"\u0000\t\'\u0001\u0000\u0000\u0000\u000b,\u0001\u0000\u0000\u0000\r2\u0001"+
		"\u0000\u0000\u0000\u000f6\u0001\u0000\u0000\u0000\u0011<\u0001\u0000\u0000"+
		"\u0000\u0013>\u0001\u0000\u0000\u0000\u0015@\u0001\u0000\u0000\u0000\u0017"+
		"K\u0001\u0000\u0000\u0000\u0019V\u0001\u0000\u0000\u0000\u001bZ\u0001"+
		"\u0000\u0000\u0000\u001db\u0001\u0000\u0000\u0000\u001f \u0005{\u0000"+
		"\u0000 \u0002\u0001\u0000\u0000\u0000!\"\u0005}\u0000\u0000\"\u0004\u0001"+
		"\u0000\u0000\u0000#$\u0005(\u0000\u0000$\u0006\u0001\u0000\u0000\u0000"+
		"%&\u0005)\u0000\u0000&\b\u0001\u0000\u0000\u0000\'(\u0005f\u0000\u0000"+
		"()\u0005u\u0000\u0000)*\u0005n\u0000\u0000*+\u0005c\u0000\u0000+\n\u0001"+
		"\u0000\u0000\u0000,-\u0005c\u0000\u0000-.\u0005l\u0000\u0000./\u0005a"+
		"\u0000\u0000/0\u0005s\u0000\u000001\u0005s\u0000\u00001\f\u0001\u0000"+
		"\u0000\u000023\u0005v\u0000\u000034\u0005a\u0000\u000045\u0005r\u0000"+
		"\u00005\u000e\u0001\u0000\u0000\u000067\u0005p\u0000\u000078\u0005r\u0000"+
		"\u000089\u0005i\u0000\u00009:\u0005n\u0000\u0000:;\u0005t\u0000\u0000"+
		";\u0010\u0001\u0000\u0000\u0000<=\u0005=\u0000\u0000=\u0012\u0001\u0000"+
		"\u0000\u0000>?\u0005,\u0000\u0000?\u0014\u0001\u0000\u0000\u0000@D\u0005"+
		"\"\u0000\u0000AB\u0005\\\u0000\u0000BE\u0005\"\u0000\u0000CE\b\u0000\u0000"+
		"\u0000DA\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HI\u0005\"\u0000\u0000I\u0016\u0001\u0000\u0000\u0000"+
		"JL\u0007\u0001\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000OQ\u0005.\u0000\u0000PR\u0007\u0001\u0000\u0000QP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000T\u0018\u0001\u0000\u0000\u0000UW\u0007\u0001\u0000"+
		"\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u001a\u0001\u0000\u0000\u0000"+
		"Z^\u0007\u0002\u0000\u0000[]\u0007\u0003\u0000\u0000\\[\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_\u001c\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"ac\u0007\u0004\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000fg\u0006\u000e\u0000\u0000g\u001e\u0001\u0000\u0000\u0000"+
		"\b\u0000DFMSX^d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}