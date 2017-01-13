package lzhou.programmingtest.leetcode.test421;

public class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int i :nums) {
            root.add(i);
        }

        int ret = 0;

        for (int i :nums) {
            ret = Math.max(ret, root.maxXor(i));
        }
        return ret;
    }
    
    class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }

        public void add(int num) {
            TrieNode cur = this;
            for (int i=31; i>=0; --i) {
                int index = 0;
                if ((num&(1<<i))!=0) {
                    index = 1;
                }
                if (cur.children[index]==null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
        }
        
        public int maxXor(int num) {
            TrieNode xorCur = this;
            int ret = 0;
            for (int i=31; i>=0; --i) {
                int index = 1;
                if ((num&(1<<i))!=0) {
                    index = 0;
                }
                if (xorCur.children[index]!=null) {
                    ret |= (1<<i);
                    xorCur = xorCur.children[index];
                } else {
                    xorCur = xorCur.children[1-index];
                }
            }
            return ret;
        }
    }
}


