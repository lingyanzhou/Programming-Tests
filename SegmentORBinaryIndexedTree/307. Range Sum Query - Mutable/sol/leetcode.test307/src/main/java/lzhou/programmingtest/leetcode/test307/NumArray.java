package lzhou.programmingtest.leetcode.test307;
import java.util.*;

public class NumArray {
    private int[] binaryIndexTree = null;
    private int[] nums = null;
    public NumArray(int[] nums) {
        binaryIndexTree = new int[nums.length+1];
        this.nums = new int[nums.length];
        
        for (int i=0; i<nums.length; ++i) {
            update(i, nums[i]);
        }
        System.arraycopy(nums,0,this.nums,0,nums.length);

    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i+=1;
        while (i<binaryIndexTree.length) {
            binaryIndexTree[i] += diff;
            i=calcNextIndex(i);
        }
    }

    /**
     * @note includive range
     */
    public int sumRange(int i, int j) {
        assert i>=0 && i<binaryIndexTree.length-1;
        assert j>=0 && j<binaryIndexTree.length-1;
        return binaryIndexTree[j+1] + parentsSum(j+1)-binaryIndexTree[i] - parentsSum(i);
    }
    
    public int parentsSum(int i) {
        if (i==0) {
            return 0;
        }
        int parentIndex = calcParentIndex(i);
        return binaryIndexTree[parentIndex] + parentsSum(parentIndex);
    }
    
    public static int calcParentIndex(int i) {
        if (0==i) {
            return 0;
        }
        return i-(i&(0xFFFFFFFF-i+1));
    }
    
    public static int calcNextIndex(int i) {
        if (0==i) {
            return 0;
        }
        return i+(i&(0xFFFFFFFF-i+1));
    }
    
    public void debug() {
        System.out.println("====");
        System.out.println(Arrays.toString(binaryIndexTree));
        System.out.println(Arrays.toString(nums));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
