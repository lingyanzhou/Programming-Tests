package lzhou.programmingtest.leetcode.test493;

import java.util.*;

/**
 * Push Down automata solution.
 */
public class Solution 
{
    public String parseTernary(String expression) {
        Stack<State> states = new Stack<State>();
        states.push(State.Begin);
        Stack<Character> expressions = new Stack<Character>();
        for (int i=0; i<expression.length() && states.peek()!=State.Invalid;) {
            if (states.peek().process(states, expressions, expression.charAt(i))) {
                i+=1;
            }
            //System.out.println(states.toString());
        }
        while (states.peek()!=State.Invalid && states.peek()!=State.Accept) {
            states.peek().process(states, expressions, '$');
            //System.out.println(states.toString());
        }
        return expressions.peek().toString();
    }
}
enum State{
    Invalid {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            return false;
        }
    },
    Accept {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            return false;
        }
    },
    Begin {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            if (charIsValue(nextChar)) {
                expressions.push(nextChar);
                states.push(Value0);
            } else {
                states.push(Invalid);
            }
            return true;
        }
    },
    Value0 {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            if (nextChar=='$') {
                states.pop();
                states.push(Accept);
            } else if (nextChar=='?') {
                states.push(Question);
            } else {
                states.push(Invalid);
            }
            return true;
        }
    },
    Question {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            if (charIsValue(nextChar)) {
                expressions.push(nextChar);
                states.push(Value1);
            } else {
                states.push(Invalid);
            }
            return true;
        }
    },
    Value1 {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            if (nextChar=='?') {
                states.push(Question);
            } else if (nextChar==':') {
                states.push(Colon);
            } else {
                states.push(Invalid);
            }
            return true;
        }
    },
    Colon {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            if (charIsValue(nextChar)) {
                expressions.push(nextChar);
                states.push(Value2);
            } else {
                states.push(Invalid);
            }
            return true;
        }
    },
    Value2 {
        public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar) {
            if (nextChar=='$') {
                reduce(states, expressions);
                return false;
            } else if (nextChar=='?') {
                states.push(Question);
            } else if (nextChar==':') {
                reduce(states, expressions);
                return false;
            } else {
                states.push(Invalid);
                return false;
            }
            return true;
        }

        private void reduce(Stack<State> states, Stack<Character> expressions) {
            states.pop();
            states.pop();
            states.pop();
            states.pop();
            states.pop();
            Character v2 = expressions.pop();
            Character v1 = expressions.pop();
            Character v0 = expressions.pop();
            if (v0=='T') {
                states.peek().process(states, expressions, v1);
            } else {
                states.peek().process(states, expressions, v2);
            }
        }
    }
    ;

    static boolean charIsValue(Character c) {
        if (c==null) {
            return false;
        }
        return c=='T' || c=='F' || Character.isDigit(c);
    }
    
    abstract public boolean process(Stack<State> states, Stack<Character> expressions, Character nextChar);
}
