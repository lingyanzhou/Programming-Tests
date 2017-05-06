package lzhou.algorithm.suffixtrie;

import java.util.*;

import java.util.stream.*;

/** A suffix trie class.
 * 4 operations:
 *  - isSuffix: whether another string t is a suffix.
 *  - isSubstring: whether another string t is a substring.
 *  - occurerences: number of occurrences of a substring t.
 *  - longestRepeat: the longest substring that repeats.
*/
class SuffixTrie {
    static private class TrieNode {
        TrieNode suffixLink;
        Character value;
        boolean isEnd;
        Map<Character, TrieNode> children;
        TrieNode (Character value) {
            this(null, value);
        }
        TrieNode (TrieNode suffixLink, Character value) {
            this.suffixLink = suffixLink;
            this.value = value;
            children = new HashMap<Character, TrieNode>();
            isEnd=false;
        }
    }

    
    private TrieNode root;
    private TrieNode longest;
    private SuffixTrie(TrieNode root, TrieNode longest) {
        this.root=root;
        this.longest = longest;
    }
    
    /** Build a suffix trie from a String.
     */
    public static SuffixTrie of(String s) {
        return of(s.toCharArray());
    }
    /** Build a suffix trie from a char sequence.
     */
    public static SuffixTrie of(char[] s) {
        TrieNode root = new TrieNode('\u0000');
        TrieNode longest = root;

        for (int i=0; i<s.length; ++i) {
            Character c = s[i];
            TrieNode cur = longest;
            TrieNode prev = null;
            while (cur!=null) {
                TrieNode n = null;
                if (cur.children.containsKey(c)) {
                    n = cur.children.get(c);
                } else {
                    n = new TrieNode(root, c);
                    cur.children.put(c, n);
                }
                if (prev!=null) {
                    prev.suffixLink = n;
                } else {
                    longest = n;
                }
                prev = n;
                cur = cur.suffixLink;
            }
        }
        TrieNode cur = longest;
        while (cur!=null) {
            cur.isEnd=true;
            cur = cur.suffixLink;
        }
        
        return new SuffixTrie(root, longest);
    }

    public boolean isSuffix(String s) {
        return isSuffix(s.toCharArray());
    }

    /**
     * Test whether the given char sequence is a suffix of the string represented by the suffix trie.
     *
     * Follow a path for s starting at the root. If we ended at a leaf node, it is a suffix.
     */
    public boolean isSuffix(char[] s) {
        TrieNode cur = root;
        int i=0;
        while (cur!=null && i!=s.length) {
            cur = cur.children.get(s[i]);
            i+=1;
        }
        return (cur!=null && cur.isEnd);
    }

    public boolean isSubstring(String s) {
        return isSubstring(s.toCharArray());
    }
    /**
     * Test whether the given char sequence is a suffix of the string represented by the suffix trie.
     *
     * Follow a path for s starting at the root. If we exhaust `s`, then it is a substring.
     */
    public boolean isSubstring(char[] s) {
        TrieNode cur = root;
        int i=0;
        while (cur!=null && i!=s.length) {
            cur = cur.children.get(s[i]);
            i+=1;
        }
        return cur!=null;
    }

    public int occurrences(String s) {
        return occurrences(s.toCharArray());
    }
    /**
     * Calculate the  number of occurrences of a string in this string.
     *
     * Follow a path for s starting at the root. The number of leaves below is the number of occurrences.
     */
    public int occurrences(char[] s) {
        TrieNode cur = root;
        int i=0;
        while (cur!=null && i!=s.length) {
            cur = cur.children.get(s[i]);
            i+=1;
        }
        return leafCount(cur);
    }

    private int leafCount(TrieNode n) {
        if (n==null) {
            return 0;
        }
        int ret = 0;
        if (n.isEnd) {
            ret = 1;
        }
        for (TrieNode t: n.children.values()) {
            ret += leafCount(t);
        }
        return ret;
    }

    /**
     * Calculate the  longest substring that repeated at least twice.
     *
     * Find the deepest node that has at least two leaves. The repeated part is the part above and include this node.
     */
    public int longestRepeat() {
        TrieNode cur = longest;
        int i=0;
        while (cur!=null) {
            if (leafCount(cur)>=2) {
                break;
            }
            cur = cur.suffixLink;
        }
        int result = 0;
        while (cur!=null && cur!=root) {
            result+=1;
            cur = cur.suffixLink;
        }
        return result;
    }
}
