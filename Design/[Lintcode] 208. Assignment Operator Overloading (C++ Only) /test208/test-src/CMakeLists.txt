enable_testing()
set(GTEST_ROOT "/usr/src/googletest/googletest/")
add_subdirectory(${GTEST_ROOT} ${CMAKE_CURRENT_BINARY_DIR}/gtest)
include_directories(${GTEST_ROOT}/include)

ADD_EXECUTABLE(lintcode_test208_test SolutionTest.cpp)

TARGET_INCLUDE_DIRECTORIES(lintcode_test208_test PUBLIC ../include)

target_link_libraries(lintcode_test208_test gtest gtest_main)
add_test(AllTests lintcode_test208_test)
