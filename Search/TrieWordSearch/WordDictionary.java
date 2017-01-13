public class WordDictionary {
  
    WordDictionary[] wordDictionary = new WordDictionary[26];
    int level=0;
    int count = 0;
    
    // Adds a word into the data structure.
    public void addWord(String word) {
      if (word==null) {
        return;
      }
      if (word.length()<level) {
        return;
      }
      if (word.length()==level) {
        count++;
          return;
      }
      char nextChar = word.charAt(level);
        int nextDictIndex = ((int)(nextChar))-97;
        if (wordDictionary[nextDictIndex]==null) {
          wordDictionary[nextDictIndex] = new WordDictionary();
            wordDictionary[nextDictIndex].level=level+1;
        }
      wordDictionary[nextDictIndex].addWord(word);
    }
  
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
      if (word==null) {
        return false;
      }
      
        if (word.length()<level) {
          return false;
        }
      if (word.length()==level) {
        return count!=0;
      }
      
        
        if (word.length()>level) {
          if (word.charAt(level)=='.') {
            for (int i=0; i<26; i++) {
              if (wordDictionary[i]!=null && wordDictionary[i].search(word)) {
                return true;
              }
            }
            return false;
          } else {
            int nextDictIndex = ((int)word.charAt(level))-97;
              if (wordDictionary[nextDictIndex]!=null) {
                return wordDictionary[nextDictIndex].search(word);
              } else {
                return false;
              }
          }
        }
      return false;
    }
}
