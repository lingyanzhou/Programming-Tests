package lzhou.programmingtest.lintcode.test58;

import java.util.*;

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        Arrays.sort(numbers);
        
        List<List<Integer>> ret= new ArrayList<List<Integer>>();
        for (int i=0; i<numbers.length-3; ) {
            for (int j=i+1; j<numbers.length-2;) {
                int k=j+1;
                int l=numbers.length-1;
                
                while (k<l) {
                    long sum = numbers[i]+numbers[j]+numbers[l]+numbers[k];
                    if (sum==target) {
                        ArrayList<Integer> list = new ArrayList<Integer>(4);
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        list.add(numbers[l]);
                        ret.add(list);
                        int oldNk=numbers[k];
                        while (k<l && numbers[k]==oldNk) {
                            k+=1;
                        }
                        int oldNl=numbers[l];
                        while (k<l && numbers[l]==oldNl) {
                            l-=1;
                        }
                    } else if (sum>target) {
                        int oldNl=numbers[l];
                        while (k<l && numbers[l]==oldNl) {
                            l-=1;
                        }
                    } else {
                        int oldNk=numbers[k];
                        while (k<l && numbers[k]==oldNk) {
                            k+=1;
                        }
                    }
                }
                
                int oldNj=numbers[j];
                while (j<numbers.length-2 && numbers[j]==oldNj) {
                    j+=1;
                }
            }
            int oldNi=numbers[i];
            while (i<numbers.length-3 && numbers[i]==oldNi) {
                i+=1;
            }
        }
        return ret;
    }
}
