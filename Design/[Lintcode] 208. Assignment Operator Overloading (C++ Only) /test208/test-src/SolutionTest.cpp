#include "gtest/gtest.h"
#include "Solution.hpp"
 
TEST (SolutionTest, NoOp) {
    Solution sol1;
    Solution sol2;
    ASSERT_EQ (NULL, sol1.m_pData);
    ASSERT_EQ (NULL, sol2.m_pData);
    sol1=sol2;
    ASSERT_EQ (NULL, sol1.m_pData);
    ASSERT_EQ (NULL, sol2.m_pData);
}
 
TEST (SolutionTest, NewOnly) {
    char* data2 = new char[2];
    strncpy(data2, "b", 2);
    Solution sol1;
    Solution sol2(data2);
    ASSERT_EQ (NULL, sol1.m_pData);
    ASSERT_STREQ ("b", sol2.m_pData);
    sol1=sol2;
    ASSERT_STREQ ("b", sol1.m_pData);
    ASSERT_STREQ ("b", sol2.m_pData);
    ASSERT_NE (sol2.m_pData, sol1.m_pData);
    
    delete[] sol1.m_pData;
    delete[] sol2.m_pData;
}
 
TEST (SolutionTest, DeleteOnly) {
    char* data1 = new char[2];
    strncpy(data1, "b", 2);
    Solution sol1(data1);
    Solution sol2;
    ASSERT_STREQ ("b", sol1.m_pData);
    ASSERT_EQ (NULL, sol2.m_pData);
    sol1=sol2;
    ASSERT_EQ (NULL, sol1.m_pData);
    ASSERT_EQ (NULL, sol2.m_pData);
}
 
TEST (SolutionTest, DeleteThenNew) {
    char* data1 = new char[2];
    strncpy(data1, "b", 2);
    char* data2 = new char[3];
    strncpy(data2, "ab", 3);
    Solution sol1(data1);
    Solution sol2(data2);
    ASSERT_STREQ ("b", sol1.m_pData);
    ASSERT_STREQ ("ab", sol2.m_pData);
    sol1=sol2;
    ASSERT_STREQ ("ab", sol1.m_pData);
    ASSERT_STREQ ("ab", sol2.m_pData);
    ASSERT_NE (sol2.m_pData, sol1.m_pData);
    
    delete[] sol1.m_pData;
    delete[] sol2.m_pData;
}

int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
