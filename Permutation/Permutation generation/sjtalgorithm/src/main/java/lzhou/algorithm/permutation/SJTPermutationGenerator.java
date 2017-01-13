package lzhou.algorithm.permutation;

import java.util.*;
/**
 * Hello world!
 *
 */
public class SJTPermutationGenerator 
{
    public List<int[]> permute(int[] nums) {
        List<int[]> ret = new ArrayList<int[]>();
        if (nums.length==0) {
            return ret;
        }
        
        Arrays.sort(nums);
        
        int[] directions = new int[nums.length];
        Arrays.fill(directions, -1);
        
        while (true) {
            int[] oneperm = new int[nums.length];
            System.arraycopy(nums, 0, oneperm, 0, nums.length);
            ret.add(oneperm);
            //System.out.println(Arrays.toString(nums));
            
            int movableIndex = -1;
            int movableValue = Integer.MIN_VALUE;
            for (int i=0; i<nums.length; ++i) {
                int movedIndex = i+directions[i];
                if (movedIndex>=0 && movedIndex<nums.length && nums[i]>nums[movedIndex] && movableValue<nums[i]) {
                    movableIndex = i;
                    movableValue = nums[i];
                }
            }
            if (movableIndex == -1) {
                break;
            }
            swap(nums, movableIndex, movableIndex+directions[movableIndex]);
            swap(directions, movableIndex, movableIndex+directions[movableIndex]);
            
            for (int i=0; i<nums.length; ++i) {
                if (nums[i]>movableValue) {
                    directions[i] = -directions[i];
                }
            }
        }
        return ret;
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
