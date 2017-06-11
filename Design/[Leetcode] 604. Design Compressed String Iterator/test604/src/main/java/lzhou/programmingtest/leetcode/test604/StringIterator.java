package lzhou.programmingtest.leetcode.test604;

import java.util.*;

import java.util.stream.*;

public class StringIterator {
    private int position = 0;
    private int repeat = 0;
    private CharCount charCount = null;

    public StringIterator(String compressedString) {
        position = 0;
        charCount = new CharCount(compressedString);
    }
    
    public char next() {
        if (hasNext()) {
            char c = charCount.chars[position];
            repeat += 1;
            if (charCount.repeats[position]==repeat) {
                repeat = 0;
                position += 1;
            }
            return c;
        } else {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        return position < charCount.len;
    }
}

class CharCount {
    int len = 0;
    char[] chars;
    int[] repeats;
    CharCount(String compressed) {
        int position = 0;
        char cur = ' ';
        int count = 0;
        for (char c : compressed.toCharArray()) {
            if (!Character.isDigit(c)) {
                len+=1;
            }
        }
        chars = new char[len];
        repeats = new int[len];
        for (char c : compressed.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count*10 + Character.digit(c,10);
            } else {
                if (count==0) {
                    cur = c;
                    count = 0;
                } else {
                    repeats[position-1] = count;
                    cur = c;
                    count = 0;
                }
                chars[position] = cur;
                position += 1;
            }
        }
        if (count>0 && position>0) {
            repeats[position-1] = count;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
