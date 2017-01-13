package lzhou.programmingtest.leetcode.test151;

public class Solution {
    public String reverseWords(String s) {
        char[] sChars = s.toCharArray();

        int length = removeAdditionalSpaces(sChars);
        reverse(sChars, 0, length);

        int wordStart = 0;
        for (int i=1; i<length; ++i) {
            if (sChars[i]==' ') {
                reverse(sChars, wordStart, i);
                wordStart = i+1;
            }
        }
        reverse(sChars, wordStart, length);

        return new String(sChars, 0, length);
    }

    private int removeAdditionalSpaces(char[] array) {
        int i=0;
        boolean prevWhiteSpaces = true;
        for (int j=0; j<array.length; ++j) {
            if (array[j]==' ' && prevWhiteSpaces) {
            } else {
                if (array[j]==' ') {
                    prevWhiteSpaces = true;
                } else {
                    prevWhiteSpaces=false;
                }
                array[i]=array[j];
                ++i;
            }
        }
        if (prevWhiteSpaces && i>0) {
            i-=1;
        }
        return i;
    }

    private void reverse(char[] array, int start, int end) {
        for (int i=(start+end)/2-1; i>=start; --i) {
            swap(array, i, start+end-i-1);
        }
    }

    private void swap(char[] array, int i, int j) {
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
