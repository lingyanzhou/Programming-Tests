package lzhou.programmingtest.leetcode.test444;

import java.util.*;

public class Solution 
{
    class IntArray {
        public int[] data;
        public IntArray(int... nums) {
            data = nums;
        }
        
        public int hashCode() {
            return Arrays.hashCode(data);
        }

        public boolean equals(Object other) {
            if (other instanceof IntArray) {
                IntArray o = (IntArray) other;
                return Arrays.equals(data, o.data);
            }
            return false;
        }
        
    }

    class MutableInt {
        private int value;
        public MutableInt(int value) {
            this.value = value;
        }
        public void set(int value) {
            this.value = value;
        }
        public int intValue() {
            return value;
        }
    }

    class MutableBoolean {
        private boolean value;
        public MutableBoolean(boolean value) {
            this.value = value;
        }
        public void set(boolean value) {
            this.value = value;
        }
        public boolean booleanValue() {
            return value;
        }
    }
    
    public boolean sequenceReconstruction(int[] original, int[][] precedences) {
        Set<IntArray> precedenceSet = new HashSet<IntArray>();

        Arrays.stream(precedences).forEach(p -> {
            MutableBoolean first = new MutableBoolean(true);
            MutableInt prev = new MutableInt(0);
            Arrays.stream(p).forEach( i-> {
                if (first.booleanValue()) {
                    first.set(false);
                } else {
                    precedenceSet.add(new IntArray(prev.intValue(), i));
                }
                prev.set(i);
            });
        });

        for (int i=0; i<original.length-1; ++i) {
            if (!precedenceSet.contains(new IntArray(original[i], original[i+1]))) {
                return false;
            }
        }

        return true;
    }
}
