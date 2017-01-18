package lzhou.programmingtest.leetcode.test65;

import java.util.*;


/**
 * State design pattern solution
 *
 * Boundary cases:
 *    1. Signs in both base and exponent part
 *    2. Decimal points with either inteter part or fractional part only
 *
 */
public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
        ParserState state = ParserState.Begining;
        
        int i=0;
        while (state!=ParserState.Invalid && i!=s.length()) {
            char c = s.charAt(i);
            state = state.parse(c);
            //System.out.println(state);
            i+=1;
        }
        return state.accept();
    }
    
    public static enum ParserState {
        Begining {
            public ParserState parse(char c) {
                if (c==' ') {
                    return this;
                } else if (c=='-') {
                    return Sign;
                } else if (c=='+') {
                    return Sign;
                } else if (Character.isDigit(c)) {
                    return IntegerPart;
                } else if (c=='.') {
                    return DotWihtoutInt;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return false;
            }
        },
        Invalid {
            public ParserState parse(char c) {
                return this;
            }
            public boolean accept() {
                return false;
            }
        },
        Sign {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return IntegerPart;
                } else if (c=='.') {
                    return DotWihtoutInt;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return false;
            }
        },
        IntegerPart {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return IntegerPart;
                } else if (c=='.') {
                    return DotWithInt;
                } else if (c=='e') {
                    return ExponentSym;
                } else if (c==' ') {
                    return Ended;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return true;
            }
        },
        DotWihtoutInt {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return FractionPart;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return false;
            }
        },
        DotWithInt {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return FractionPart;
                } else if (c=='e') {
                    return ExponentSym;
                } else if (c==' ') {
                    return Ended;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return true;
            }
        },
        FractionPart {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return FractionPart;
                } else if (c=='e') {
                    return ExponentSym;
                } else if (c==' ') {
                    return Ended;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return true;
            }
        },
        ExponentSym {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return Exponent;
                } else if (c=='+') {
                    return ExponentSign;
                } else if (c=='-') {
                    return ExponentSign;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return false;
            }
        },
        ExponentSign {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return Exponent;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return false;
            }
        },
        Exponent {
            public ParserState parse(char c) {
                if (Character.isDigit(c)) {
                    return Exponent;
                } else if (c==' ') {
                    return Ended;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return true;
            }
        },
        Ended {
            public ParserState parse(char c) {
                if (c==' ') {
                    return this;
                } else {
                    return Invalid;
                }
            }
            public boolean accept() {
                return true;
            }
        };
        
        abstract public ParserState parse(char c);
        abstract public boolean accept();
    }
}
