package lzhou.programmingtest.leetcode.test592;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public String fractionAddition(String expression) {
        Rational result = null;
        for (int i=0, turn = 0; i<expression.length(); turn = (turn+1)%2) {
            ReturnStruct<Rational> tmp = parseRational(expression, i);
            i+= tmp.consumed;
            if (result==null) {
                result = tmp.value;
            } else {
                result = result.add(tmp.value);
            }
        }
        if (result==null) {
            return "";
        }
        return result.toString();
    }
    
    public ReturnStruct<Rational> parseRational(String expression, int start) {
        int sign = 1;
        int numerator = 0;
        int denominator = 0;
        boolean first = true;
        boolean parsingDenominator = false;
        boolean done = false;
        int consumed = 0;
        for (int i=start; i<expression.length() && !done; ++i) {
            char c = expression.charAt(i);
            switch (c) {
                case '+':
                    if (first) {
                        sign = 1;
                        first = false;
                        consumed += 1;
                    } else if (!parsingDenominator) {
                        throw new RuntimeException();
                    } else {
                        done=true;
                    }
                    break;
                case '-':
                    if (first) {
                        sign = -1;
                        first = false;
                        consumed += 1;
                    } else if (!parsingDenominator) {
                        throw new RuntimeException();
                    } else {
                        done=true;
                    }
                    break;
                case '/':
                    if (first) {
                        throw new RuntimeException();
                    }
                    parsingDenominator = true;
                    consumed += 1;
                    break;
                default:
                    first = false;
                    if (Character.isDigit(c)) {
                        if (parsingDenominator) {
                            denominator = Character.digit(c,10)+denominator*10;
                        } else {
                            numerator = Character.digit(c,10)+numerator*10;
                        }
                        consumed += 1;
                    } else {
                        throw new RuntimeException();
                    }
                    break;
            }
        }
        return new ReturnStruct(new Rational(sign*numerator, denominator), consumed);
    }
    
    public ReturnStruct<Character> parseOperator(String expression, int start) {
        char c = expression.charAt(start);
        if (c!='+' && c!='-') {
            throw new RuntimeException();
        }
        return new ReturnStruct(c, 1);
    }
    
   
}
class ReturnStruct<T> {
    T value;
    int consumed;
    ReturnStruct(T v, int c) {
        value = v;
        consumed = c;
    }
}
    
class Rational {
    long numerator;
    long denominator;
    
    Rational(long n, long d) {
        numerator = n;
        denominator = d;
        simplify();
    }
    
    Rational add(Rational other) {
        long tmp = lcm(denominator, other.denominator);
        return new Rational(tmp/denominator*numerator+tmp/other.denominator*other.numerator, tmp);
    }
    
    void simplify() {
        long tmp = gcd(Math.abs(numerator), denominator);
        
        numerator = numerator/tmp;
        denominator = denominator/tmp;
    }
    
    static long gcd(long a, long b) {
        if (a==0L) {
            return b;
        }
        return gcd(b%a, a);
    }
    
    static long lcm(long a, long b) {
        long tmp = gcd(a,b);
        return a/tmp*b;
    }
    
    public String toString() {
        return String.format("%1$d/%2$d", numerator, denominator);
    }
}
