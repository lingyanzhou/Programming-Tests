package question540;


import "testing"

type TestCase struct {
nums []int
expected int
}

var tests = []TestCase{
    TestCase{[]int{1}, 1},
    TestCase{[]int{1,1,2}, 2},
    TestCase{[]int{1,2,2}, 1},
    TestCase{[]int{1,2,2,3,3}, 1},
    TestCase{[]int{1,1,2,3,3}, 2},
    TestCase{[]int{1,1,2,2,3}, 3},
    TestCase{[]int{1,2,2,3,3,4,4}, 1},
    TestCase{[]int{1,1,2,3,3,4,4}, 2},
    TestCase{[]int{1,1,2,2,3,4,4}, 3},
    TestCase{[]int{1,1,2,2,3,3,4}, 4},
}


func Test_change(t *testing.T) {
    for i, test:= range tests {
        actual := singleNonDuplicate(test.nums)
        if actual!=test.expected {
            t.Errorf("[Test %d] is %d, but was %d", i, test.expected, actual)
        }
    }
}
