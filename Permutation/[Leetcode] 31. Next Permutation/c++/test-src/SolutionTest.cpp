#include "gtest/gtest.h"
#include "Solution.hpp"
#include <vector>
#include <iostream>

void assert_vector_equals(std::vector<int> expected, std::vector<int> actual) {
    ASSERT_EQ(expected.size(), actual.size());
    for (int i=0; i<expected.size(); ++i) {
        ASSERT_EQ(expected[i], actual[i]);
    }
}
 
TEST (SolutionTest, LastPerm) {
    std::vector<int> in = {3,2,1};
    std::vector<int> expected = {1,2,3};
    Solution sol1;
    std::vector<int> actual = sol1.nextPermutation(in);
    assert_vector_equals(expected, actual);
}
 
TEST (SolutionTest, FirstPerm) {
    std::vector<int> in = {1,2,3,4,5};
    std::vector<int> expected = {1,2,3,5,4};
    Solution sol1;
    std::vector<int> actual = sol1.nextPermutation(in);
    assert_vector_equals(expected, actual);
}
 
TEST (SolutionTest, PermWith1ReverseSeqAtTail) {
    std::vector<int> in = {1,2,5,4,3};
    std::vector<int> expected = {1,3,2,4,5};
    Solution sol1;
    std::vector<int> actual = sol1.nextPermutation(in);
    assert_vector_equals(expected, actual);
}
 
TEST (SolutionTest, PermWith1ReverseSeqAtMiddle) {
    std::vector<int> in = {1,2,4,3,5,6};
    std::vector<int> expected = {1,2,4,3,6,5};
    Solution sol1;
    std::vector<int> actual = sol1.nextPermutation(in);
    assert_vector_equals(expected, actual);
}
 
TEST (SolutionTest, PermWith2ReverseSeq) {
    std::vector<int> in = {1,2,5,4,3,9,8,7};
    std::vector<int> expected = {1,2,5,4,7,3,8,9};
    Solution sol1;
    std::vector<int> actual = sol1.nextPermutation(in);
    assert_vector_equals(expected, actual);
}

int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
