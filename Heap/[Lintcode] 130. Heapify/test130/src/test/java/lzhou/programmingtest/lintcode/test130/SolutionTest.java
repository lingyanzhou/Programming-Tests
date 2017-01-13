package lzhou.programmingtest.lintcode.test130;

import java.util.*;
import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SolutionTest {
    
    //global timeout rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);
    
    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        //System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        //System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        //System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        //System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_solution_len1() {
        int[] A = new int[]{1};
        new Solution().heapify(A);
        assertTrue(isMinHeap(A));
    }

    @Test
    public void test_solution_ordered() {
        int[] A={1,3,5,4};
        new Solution().heapify(A);
        assertTrue(isMinHeap(A));
    }

    @Test
    public void test_solution_not_ordered() {
        int[] A={5,1,4,2,7,3};
        new Solution().heapify(A);
        assertTrue(isMinHeap(A));
    }

    @Test
    public void test_solution_largeset() {
        int[] A={1132, 34, 1372, 1197, 336, 1505, 1468, 1553, 655, 451, 259, 392, 1277, 103, 1476, 1147, 237, 185, 740, 15, 1478, 867, 1129, 298, 631, 883, 236, 1445, 452, 31, 1541, 107, 1095, 1135, 1285, 321, 894, 489, 1352, 826, 19, 1174, 732, 1228, 1466, 1202, 547, 1538, 1235, 698, 419, 558, 1118, 1227, 648, 530, 868, 1374, 217, 658, 876, 997, 834, 946, 567, 993, 1255, 468, 1248, 1189, 1523, 839, 1533, 1335, 1117, 1094, 859, 1292, 725, 1018, 251, 744, 1453, 267, 1541, 1148, 872, 1378, 286, 1034, 1465, 40, 1186, 1234, 658, 189, 1387, 1488, 1413, 907};
        new Solution().heapify(A);
        assertTrue(isMinHeap(A));
    }
    
    private boolean isMinHeap(int[] a) {
        for (int i=a.length-1; i>0; --i) {
            if (a[i]<a[parent(i)]) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    private int parent(int i) {
        return (i+1)/2-1;
    }
    
    private int child1(int i) {
        return 2*i+1;
    }
    private int child2(int i) {
        return 2*i+2;
    }
}
