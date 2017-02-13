package question498

import "testing"

type TestCase struct {
    matrix [][]int
    expected []int
}

var tests = []TestCase{
    TestCase{matrix: [][]int{{1}}, expected: []int{1}},
    TestCase{matrix: [][]int{{1,2}}, expected: []int{1,2}},
    TestCase{matrix: [][]int{{1}, {2}}, expected: []int{1,2}},
    TestCase{matrix: [][]int{{1,2},{3,4}}, expected: []int{1,2,3,4}},
    TestCase{matrix: [][]int{{1,2},{3,4},{5,6}}, expected: []int{1,2,3,5,4,6}},
    TestCase{matrix: [][]int{{1,2,3},{4,5,6}}, expected: []int{1,2,4,5,3,6}},
    }

func Test_findDiagnalOrder(t *testing.T) {
    for i, te := range tests {
        actual := findDiagonalOrder(te.matrix)
        if len(actual)!=len(te.expected) {
            t.Errorf("[Test %d] is %v \n\t was %v", i, te.expected, actual)
        }
        for i, _ :=range te.expected {
            if actual[i]!=te.expected[i] {
                t.Errorf("[Test %d] is %v \n\t was %v", i, te.expected, actual)
            }
        }
    }
}
