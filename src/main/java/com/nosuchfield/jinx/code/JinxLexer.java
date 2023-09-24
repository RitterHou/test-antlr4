// Generated from D:/Projects/test-antlr4/src/main/resources/jinx\Jinx.g4 by ANTLR 4.12.0

package com.nosuchfield.jinx.code;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JinxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_BR=1, RIGHT_BR=2, CLASS=3, VARIABLE=4, PRINT=5, EQUALS=6, STRING=7, 
		DOUBLE=8, INT=9, ID=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LEFT_BR", "RIGHT_BR", "CLASS", "VARIABLE", "PRINT", "EQUALS", "STRING", 
			"DOUBLE", "INT", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'class'", "'var'", "'print'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LEFT_BR", "RIGHT_BR", "CLASS", "VARIABLE", "PRINT", "EQUALS", 
			"STRING", "DOUBLE", "INT", "ID", "WS"
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
		"\u0004\u0000\u000bU\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0004\u00062\b\u0006\u000b\u0006\f\u00063\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0004\u00079\b\u0007\u000b\u0007\f\u0007:\u0001\u0007"+
		"\u0001\u0007\u0004\u0007?\b\u0007\u000b\u0007\f\u0007@\u0001\b\u0004\b"+
		"D\b\b\u000b\b\f\bE\u0001\t\u0001\t\u0005\tJ\b\t\n\t\f\tM\t\t\u0001\n\u0004"+
		"\nP\b\n\u000b\n\f\nQ\u0001\n\u0001\n\u0000\u0000\u000b\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0001\u0000\u0005\u0001\u0000\"\"\u0001\u00000"+
		"9\u0002\u0000AZaz\u0003\u000009AZaz\u0003\u0000\t\n\r\r  [\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003\u0019\u0001\u0000"+
		"\u0000\u0000\u0005\u001b\u0001\u0000\u0000\u0000\u0007!\u0001\u0000\u0000"+
		"\u0000\t%\u0001\u0000\u0000\u0000\u000b+\u0001\u0000\u0000\u0000\r-\u0001"+
		"\u0000\u0000\u0000\u000f8\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000"+
		"\u0000\u0013G\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0005{\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0005}\u0000\u0000\u001a\u0004\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"c\u0000\u0000\u001c\u001d\u0005l\u0000\u0000\u001d\u001e\u0005a\u0000"+
		"\u0000\u001e\u001f\u0005s\u0000\u0000\u001f \u0005s\u0000\u0000 \u0006"+
		"\u0001\u0000\u0000\u0000!\"\u0005v\u0000\u0000\"#\u0005a\u0000\u0000#"+
		"$\u0005r\u0000\u0000$\b\u0001\u0000\u0000\u0000%&\u0005p\u0000\u0000&"+
		"\'\u0005r\u0000\u0000\'(\u0005i\u0000\u0000()\u0005n\u0000\u0000)*\u0005"+
		"t\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005=\u0000\u0000,\f\u0001"+
		"\u0000\u0000\u0000-1\u0005\"\u0000\u0000./\u0005\\\u0000\u0000/2\u0005"+
		"\"\u0000\u000002\b\u0000\u0000\u00001.\u0001\u0000\u0000\u000010\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0005\"\u0000\u0000"+
		"6\u000e\u0001\u0000\u0000\u000079\u0007\u0001\u0000\u000087\u0001\u0000"+
		"\u0000\u00009:\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0005.\u0000\u0000=?\u0007"+
		"\u0001\u0000\u0000>=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0010\u0001\u0000"+
		"\u0000\u0000BD\u0007\u0001\u0000\u0000CB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"F\u0012\u0001\u0000\u0000\u0000GK\u0007\u0002\u0000\u0000HJ\u0007\u0003"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\u0014\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000NP\u0007\u0004\u0000\u0000ON\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0006\n\u0000\u0000T\u0016"+
		"\u0001\u0000\u0000\u0000\b\u000013:@EKQ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}