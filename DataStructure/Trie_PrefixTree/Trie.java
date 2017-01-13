class TrieNode {
  private int level=0;
  private int count = 0;
  private TrieNode[] trieNodes = new TrieNode[26] ;

  // Initialize your data structure here.
  public TrieNode() {
    level=0;
    count = 0;
  }
  public TrieNode(int level) {
    this.level=level;
    count = 0;
  }
  public void insert(String word) {
    if (word.length()<level) {
      return;
    }
    if (word.length()==level) {
      count++;
      return;
    }
    int nextChildrenIndex = word.charAt(level)-'a';
    if (trieNodes[nextChildrenIndex]==null) {
      trieNodes[nextChildrenIndex] = new TrieNode(level+1);
    }
    trieNodes[nextChildrenIndex].insert(word);
  }

  public boolean search (String word) {
    if (word.length()==level) {
      return count!=0;
    }
    if (word.length()<level) {
      return false;
    }
    if (word.length()>level) {
      int nextChildrenIndex = word.charAt(level)-'a';
      if (trieNodes[nextChildrenIndex]==null) {
        return false;
      } else {
        return trieNodes[nextChildrenIndex].search(word);
      }
    }
    return false;
  }

  public boolean startsWith (String word) {
    if (word.length()<=level) {
      if (count!=0) {
        return true;
      } else {
        for (int i=0; i<26; i++) {
          if (trieNodes[i]==null || ! trieNodes[i].startsWith(word)) {
          } else {
            return true;
          }
        }
      }
    }
    if (word.length()>level) {
      int nextChildrenIndex = word.charAt(level)-'a';
      if (trieNodes[nextChildrenIndex]==null) {
        return false;
      } else {
        return trieNodes[nextChildrenIndex].startsWith(word);
      }
    }
    return false;
  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    root.insert(word);
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    return root.search(word);
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    return root.startsWith(prefix);
  }

  /*
   * public static void main(String[] args) {

    Trie trie = new Trie();
    trie.insert("somestring");
    System.out.println(trie.search("key"));
    System.out.println(trie.startsWith("somestrings"));

  }*/

}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
