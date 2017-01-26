package lzhou.programmingtest.leetcode.test360;

import java.util.*;

public class Solution 
{
    public List<Integer> sortTransformedArray(int[] nums, int a, int b, int c) {
        if (a==0) {
            if (b>0) {
                return sortTransformedArrayAEq0BGt0(nums, a, b, c);
            } else {
                return sortTransformedArrayAEq0BLteq0(nums, a, b, c);
            }
        } else if (a<0) {
            return sortTransformedArrayALt0(nums, a, b, c);
        } else {
            
            return sortTransformedArrayAGt0(nums, a, b, c);
        }
    }

    public List<Integer> sortTransformedArrayAGt0(int[] nums, int a, int b, int c) {
        double symPoint = -(double)b/2.0/(double)a;
        int i=(int) Math.ceil(symPoint);
        List<Integer> ret = new ArrayList<Integer>();
        
        int p1 = Arrays.binarySearch(nums, i);
        if (p1<0) {
            p1=-1-p1;
        }
        int p2 = p1-1;

        while (p1<nums.length || p2>=0) {
            if (p1<nums.length && p2>=0) {
                if (nums[p1]-symPoint>=symPoint-nums[p2]) {
                    ret.add(transform(nums[p2], a,b,c));
                    p2-=1;
                } else {
                    ret.add(transform(nums[p1], a,b,c));
                    p1+=1;
                }
            } else if (p1<nums.length) {
                ret.add(transform(nums[p1], a,b,c));
                p1+=1;
            } else if (p2>=0) {
                ret.add(transform(nums[p2], a,b,c));
                p2-=1;
            }
        }

        return ret;
    }
    
    public List<Integer> sortTransformedArrayALt0(int[] nums, int a, int b, int c) {
        double symPoint = -(double)b/2.0/(double)a;
        int i=(int) Math.ceil(symPoint);
        List<Integer> ret = new ArrayList<Integer>();
        
        int p1 = 0;
        int p2 = nums.length-1;

        while (p1<=p2) {
            if (nums[p2]-symPoint>=symPoint-nums[p1]) {
                ret.add(transform(nums[p2], a,b,c));
                p2-=1;
            } else {
                ret.add(transform(nums[p1], a,b,c));
                p1+=1;
            }
        }

        return ret;
    }
    
    public List<Integer> sortTransformedArrayAEq0BGt0(int[] nums, int a, int b, int c) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i=0; i<nums.length; ++i) {
            ret.add(transform(nums[i], a,b,c));
        }
        return ret;
    }
    
    public List<Integer> sortTransformedArrayAEq0BLteq0(int[] nums, int a, int b, int c) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i=nums.length-1; i>=0; --i) {
            ret.add(transform(nums[i], a,b,c));
        }
        return ret;
    }

    private int transform(int x, int a, int b, int c) {
        return a*x*x+b*x+c;
    }
}
