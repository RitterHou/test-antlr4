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
		VARIABLE=1, PRINT=2, EQUALS=3, STRING=4, NUMBER=5, ID=6, WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VARIABLE", "PRINT", "EQUALS", "STRING", "NUMBER", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'print'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VARIABLE", "PRINT", "EQUALS", "STRING", "NUMBER", "ID", "WS"
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
		"\u0004\u0000\u0007@\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003 \b\u0003\u000b\u0003"+
		"\f\u0003!\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004\'\b\u0004\u000b"+
		"\u0004\f\u0004(\u0001\u0004\u0001\u0004\u0004\u0004-\b\u0004\u000b\u0004"+
		"\f\u0004.\u0003\u00041\b\u0004\u0001\u0005\u0001\u0005\u0005\u00055\b"+
		"\u0005\n\u0005\f\u00058\t\u0005\u0001\u0006\u0004\u0006;\b\u0006\u000b"+
		"\u0006\f\u0006<\u0001\u0006\u0001\u0006\u0000\u0000\u0007\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u0001"+
		"\u0000\u0005\u0001\u0000\"\"\u0001\u000009\u0002\u0000AZaz\u0003\u0000"+
		"09AZaz\u0003\u0000\t\n\r\r  F\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0001\u000f\u0001"+
		"\u0000\u0000\u0000\u0003\u0013\u0001\u0000\u0000\u0000\u0005\u0019\u0001"+
		"\u0000\u0000\u0000\u0007\u001b\u0001\u0000\u0000\u0000\t&\u0001\u0000"+
		"\u0000\u0000\u000b2\u0001\u0000\u0000\u0000\r:\u0001\u0000\u0000\u0000"+
		"\u000f\u0010\u0005v\u0000\u0000\u0010\u0011\u0005a\u0000\u0000\u0011\u0012"+
		"\u0005r\u0000\u0000\u0012\u0002\u0001\u0000\u0000\u0000\u0013\u0014\u0005"+
		"p\u0000\u0000\u0014\u0015\u0005r\u0000\u0000\u0015\u0016\u0005i\u0000"+
		"\u0000\u0016\u0017\u0005n\u0000\u0000\u0017\u0018\u0005t\u0000\u0000\u0018"+
		"\u0004\u0001\u0000\u0000\u0000\u0019\u001a\u0005=\u0000\u0000\u001a\u0006"+
		"\u0001\u0000\u0000\u0000\u001b\u001f\u0005\"\u0000\u0000\u001c\u001d\u0005"+
		"\\\u0000\u0000\u001d \u0005\"\u0000\u0000\u001e \b\u0000\u0000\u0000\u001f"+
		"\u001c\u0001\u0000\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"#\u0001\u0000\u0000\u0000#$\u0005\"\u0000\u0000$\b\u0001\u0000"+
		"\u0000\u0000%\'\u0007\u0001\u0000\u0000&%\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000"+
		")0\u0001\u0000\u0000\u0000*,\u0005.\u0000\u0000+-\u0007\u0001\u0000\u0000"+
		",+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000"+
		"\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000*\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u00001\n\u0001\u0000\u0000\u000026\u0007"+
		"\u0002\u0000\u000035\u0007\u0003\u0000\u000043\u0001\u0000\u0000\u0000"+
		"58\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u00007\f\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009;\u0007\u0004"+
		"\u0000\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">?\u0006\u0006\u0000\u0000?\u000e\u0001\u0000\u0000\u0000\b\u0000\u001f"+
		"!(.06<\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}