package lzhou.programmingtest.leetcode.test211;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class WordDictionaryTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WordDictionaryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WordDictionaryTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testWordDictionary1()
    {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        assertTrue(wd.search("bad"));
        assertFalse(wd.search("dad"));
        wd.addWord("dad");
        assertTrue(wd.search("bad"));
        assertTrue(wd.search("dad"));
        assertFalse(wd.search("mad"));
        wd.addWord("mad");
        assertTrue(wd.search("bad"));
        assertTrue(wd.search("dad"));
        assertTrue(wd.search("mad"));
        assertFalse(wd.search("pad"));
        assertTrue(wd.search(".ad"));
        assertTrue(wd.search("b.."));
        assertTrue(wd.search("b.."));
        assertFalse(wd.search("b..."));
        assertFalse(wd.search("...."));
        assertFalse(wd.search("..b"));
        assertFalse(wd.search("badb"));
    }
}
