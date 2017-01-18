package lzhou.programmingtest.leetcode.test488;

import java.util.*;

/**
 * Back tracking
 * Idea
 *   1. Meaningful steps are 1 or 2 additions that will result in 3 consequtive identical elements that will be erased.
 *   2. For a step to be meaningful, the inserted color must be the same as its nearby colors.
 *   3. For a single color, there can be multiple places to insert that results in meaningful steps. Thus we use back tracking.
 *   4. In each recursion, we try from left to right, whether we have the color in our hand and is enough to make 3 same consecutive color. If one addition can result in a meaningful step, try it. If not, try 2 additions. 
 *   5. After we eliminated 3 elements, we check whether the concatenated new board can be futher shrinked.
 */
public class Solution {
    public int findMinStep(String board, String hand) {
        int len = 0;
        int[] boardInt = new int[board.length()];
        int[] boardCounts = new int[board.length()];
        int[] handCounts = new int[5];
        
        for (int i=0; i<hand.length(); ++i) {
            handCounts[colorToInt(hand.charAt(i))]+=1;
        }
        
        for (int i=0, prev=-1; i<board.length(); ++i) {
            int cur = colorToInt(board.charAt(i));
            if (cur==prev) {
                boardCounts[len-1]+=1;
            } else {
                boardInt[len]=cur;
                boardCounts[len]=1;
                len+=1;
            }
            prev=cur;
        }
        
        return findMinStep(boardInt, boardCounts, len, handCounts);
    }
    
    private int findMinStep(int[] boardInt, int[] boardCounts, int len, int[] handCounts) {
        if (len==0) {
            return 0;
        }
        int lenTmp = len;
        int[] boardIntTmp = Arrays.copyOf(boardInt, len);
        int[] boardCountsTmp = Arrays.copyOf(boardCounts, len);
        int[] handCountsTmp = Arrays.copyOf(handCounts, handCounts.length);
        int minStep = -1;
        
        for (int i=0; i<len; ++i) {
                //System.out.println(Arrays.toString(boardIntTmp));
                //System.out.println(Arrays.toString(boardCountsTmp));
                //System.out.println(Arrays.toString(handCounts));
            if (boardCounts[i]+handCounts[boardInt[i]]>=3) {
                lenTmp= len;
                System.arraycopy(boardInt, 0, boardIntTmp, 0, len);
                System.arraycopy(boardCounts, 0, boardCountsTmp, 0, len);
                System.arraycopy(handCounts, 0, handCountsTmp, 0, handCounts.length);
                int thisStep = 3-boardCountsTmp[i];
                handCountsTmp[boardInt[i]]-= thisStep;
                boardCountsTmp[i]=3;
                lenTmp = removeSaturated(boardIntTmp, boardCountsTmp, len, i);
                int futureStep = findMinStep(boardIntTmp, boardCountsTmp, lenTmp, handCountsTmp);
                if (futureStep!=-1) {
                    if (minStep==-1 || minStep>futureStep+thisStep) {
                        minStep = futureStep+thisStep;
                    }
                }
            } else {
                continue;
            }
        }
        return minStep;
    }
    
    private int removeSaturated(int[] boardInt, int[] boardCounts, int len, int saturated) {
        int left = saturated-1;
        int right = saturated+1;
        int newLen = len;
        while (left>=0 && right <len && boardInt[left]==boardInt[right] && boardCounts[left]+boardCounts[right]>=3) {
            left-=1;
            right+=1;
        }
        if (left>=0 && right <len && boardInt[left]==boardInt[right]) {
            boardCounts[left]+=boardCounts[right];
            right+=1;
        }
        newLen=left+1;
        for (; right<len; ++newLen, ++right) {
            boardInt[newLen]=boardInt[right];
            boardCounts[newLen]=boardCounts[right];
        }
        return newLen;
    }
    
    private static int colorToInt(char c) {
        switch(c) {
            case 'R':
                return 0;
            case 'Y':
                return 1;
            case 'B':
                return 2;
            case 'G':
                return 3;
            case 'W':
                return 4;
            default:
                return 0;
        }
    }
}
