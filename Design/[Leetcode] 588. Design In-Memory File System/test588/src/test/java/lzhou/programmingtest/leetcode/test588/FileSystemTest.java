package lzhou.programmingtest.leetcode.test588;

import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.rules.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;


public class FileSystemTest {
    @Test
    public void test_1() {
        FileSystem fs = new FileSystem();
        assertThat(fs.ls("/"), hasSize(0));
        fs.mkdir("/a");
        assertThat(fs.ls("/"), contains("a"));
        fs.addContentToFile("/a/b", "hello");
        assertThat(fs.ls("/"), contains("a"));
        assertThat(fs.ls("/a"), contains("b"));
        assertThat(fs.readContentFromFile("/a/b"), is("hello"));
    }
    
    @Test
    public void test_2() {
        FileSystem fs = new FileSystem();
        assertThat(fs.ls("/"), hasSize(0));
        fs.mkdir("/a/b");
        fs.addContentToFile("/a/b/c", "hello");
        assertThat(fs.ls("/"), contains("a"));
        assertThat(fs.ls("/a"), contains("b"));
        assertThat(fs.ls("/a/b"), contains("c"));
        assertThat(fs.ls("/a/b/c"), contains("c"));
        assertThat(fs.readContentFromFile("/a/b/c"), is("hello"));
    }
    
    @Test
    public void test_3() {
        FileSystem fs = new FileSystem();
        assertThat(fs.ls("/"), hasSize(0));
        fs.mkdir("/a/b");
        fs.addContentToFile("/a/b/c", "hello");
        fs.addContentToFile("/a/b/c", " world");
        fs.addContentToFile("/a/b/c2", "hello");
        assertThat(fs.ls("/a"), contains("b"));
        assertThat(fs.ls("/a/b"), contains("c","c2"));
        assertThat(fs.readContentFromFile("/a/b/c"), is("hello world"));
        assertThat(fs.readContentFromFile("/a/b/c2"), is("hello"));
    }
    
    @Test
    public void test_4() {
        FileSystem fs = new FileSystem();
        assertThat(fs.ls("/"), hasSize(0));
        fs.mkdir("/a/b");
        fs.mkdir("/a/b2/c");
        fs.mkdir("/a2/b3/c2");
        fs.addContentToFile("/a2/b4", "hello");
        assertThat(fs.ls("/"), contains("a","a2"));
        assertThat(fs.ls("/a"), contains("b","b2"));
        assertThat(fs.ls("/a2"), contains("b3","b4"));
        assertThat(fs.ls("/a/b"), hasSize(0));
        assertThat(fs.ls("/a/b2"), contains("c"));
        assertThat(fs.readContentFromFile("/a2/b4"), is("hello"));
    }
}
