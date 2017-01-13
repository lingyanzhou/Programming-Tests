#ifndef __SOLUTION_HPP__
#define __SOLUTION_HPP__

#include <cstring>
#include <vector>
#include <algorithm>
#include <iostream>

class Solution {
public:
    /**
     * @param nums: An array of integers
     * @return: An array of integers that's next permuation
     */
    std::vector<int> nextPermutation(std::vector<int> &nums) {
        // write your code here
        if (nums.size()==0) {
            return nums;
        }
        int lastIncIndex = -1;
        for (int i=nums.size()-1; i>=1; --i) {
            if (nums[i]>nums[i-1]) {
                lastIncIndex = i-1;
                break;
            }
        }
        
        reverse(nums, lastIncIndex+1, nums.size());
        
        if (lastIncIndex==-1) {
            return nums;
        }
        
        std::vector<int>::iterator upper = std::upper_bound(nums.begin()+(lastIncIndex+1), nums.end(), nums[lastIncIndex]);
        
        
        swap(nums, upper-nums.begin(), lastIncIndex);
        return nums;
    }
    
private:
    void swap(std::vector<int> &nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    void reverse(std::vector<int> &nums, int start, int end) {
        int mid = (start+end)/2;
        for (int i=start; i<mid; ++i) {
            swap(nums, i, start+end-1-i);
        }
    }
};

#endif // __SOLUTION_HPP__
