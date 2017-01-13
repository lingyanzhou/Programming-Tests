package lzhou.programmingtest.leetcode.test421;

public class Solution2 {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int i :nums) {
            root.add(i);
        }

        return findMaximumXORHelper1(root, 31);
    }

    private int findMaximumXORHelper1(TrieNode node, int bitPos) {
        if (node==null) {
            return 0;
        }
        if (node.children[0]==null && node.children[1]==null) {
            return 0;
        }
        if (node.children[0]==null) {
            return findMaximumXORHelper1(node.children[1], bitPos-1);
        }
        if (node.children[1]==null) {
            return findMaximumXORHelper1(node.children[0], bitPos-1);
        }

        return (1<<bitPos)+findMaximumXORHelper2(node.children[0], node.children[1], bitPos-1);
    }

    private int findMaximumXORHelper2(TrieNode node0, TrieNode node1, int bitPos) {
        if (node0==null || node1==null) {
            return Math.max(findMaximumXORHelper1(node0, bitPos), findMaximumXORHelper1(node1, bitPos));
        }
        int ret = 0;
        if (node0.children[0]!=null && node1.children[1]!=null) {
            ret = (1<<bitPos)+findMaximumXORHelper2(node0.children[0], node1.children[1], bitPos-1);
        }
        if (node0.children[1]!=null && node1.children[0]!=null) {
            ret = Math.max(ret, (1<<bitPos)+findMaximumXORHelper2(node0.children[1], node1.children[0], bitPos-1));
        }
        if (ret==0) {
            ret = Math.max(findMaximumXORHelper2(node0.children[0], node1.children[0], bitPos-1), findMaximumXORHelper2(node0.children[1], node1.children[1], bitPos-1));
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
    }
}


