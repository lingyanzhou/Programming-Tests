enable_testing()
set(GTEST_ROOT "/usr/src/googletest/googletest/")
add_subdirectory(${GTEST_ROOT} ${CMAKE_CURRENT_BINARY_DIR}/gtest)
include_directories(${GTEST_ROOT}/include)

ADD_EXECUTABLE(lintcode_test31_test SolutionTest.cpp)
set_property(TARGET lintcode_test31_test PROPERTY CXX_STANDARD 11)

TARGET_INCLUDE_DIRECTORIES(lintcode_test31_test PUBLIC ../include)

target_link_libraries(lintcode_test31_test gtest gtest_main)
add_test(AllTests lintcode_test31_test)
