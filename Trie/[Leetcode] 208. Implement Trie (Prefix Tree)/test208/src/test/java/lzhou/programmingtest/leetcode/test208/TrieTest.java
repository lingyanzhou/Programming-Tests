package lzhou.programmingtest.leetcode.test208;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TrieTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TrieTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TrieTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testTrie1()
    {
        Trie trie = new Trie();
        trie.insert("abcd");
        assertTrue(trie.search("abcd"));
        assertFalse(trie.search("abc"));
        assertFalse(trie.search("acd"));
        assertFalse(trie.search("abcde"));
        assertTrue(trie.startsWith("abcd"));
        assertTrue(trie.startsWith("a"));
        assertFalse(trie.startsWith("abd"));
        assertFalse(trie.startsWith("abcde"));
    }

    
    public void testTrie2()
    {
        Trie trie = new Trie();
        trie.insert("abcd");
        assertTrue(trie.search("abcd"));
        assertFalse(trie.search("abcde"));
        trie.insert("abcde");
        assertTrue(trie.search("abcd"));
        assertTrue(trie.search("abcde"));
        assertFalse(trie.search("abc"));
        assertFalse(trie.search("acd"));
        assertFalse(trie.search("abcdef"));
        assertTrue(trie.startsWith("abcd"));
        assertTrue(trie.startsWith("a"));
        assertFalse(trie.startsWith("abd"));
        assertTrue(trie.startsWith("abcde"));
    }
    public void testTrie3()
    {
        Trie trie = new Trie();
        trie.insert("abcd");
        assertTrue(trie.search("abcd"));
        assertFalse(trie.search("acb"));
        trie.insert("acb");
        assertTrue(trie.search("abcd"));
        assertTrue(trie.search("acb"));
        assertFalse(trie.search("abc"));
        assertFalse(trie.search("acbe"));
        assertFalse(trie.search("abcde"));
        assertTrue(trie.startsWith("abcd"));
        assertTrue(trie.startsWith("a"));
        assertTrue(trie.startsWith("ac"));
        assertTrue(trie.startsWith("acb"));
        assertFalse(trie.startsWith("abcde"));
    }
}
