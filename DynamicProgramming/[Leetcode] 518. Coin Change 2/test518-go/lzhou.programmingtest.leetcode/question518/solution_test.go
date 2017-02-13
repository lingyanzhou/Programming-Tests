package question518

import "testing"

type TestCase struct {
    coins []int
    amount int
    expected int
}

var tests = []TestCase{
        TestCase{[]int{1}, 1, 1},
        TestCase{[]int{1}, 2, 1},
        TestCase{[]int{1,2}, 2, 2},
        TestCase{[]int{1,2}, 4, 3},
        TestCase{[]int{1,2,3,5}, 5, 6},
        TestCase{[]int{1,2,3,5}, 15, 47},
}


func Test_change(t *testing.T) {
    for i, test:= range tests {
        actual := change(test.amount, test.coins)
        if actual!=test.expected {
            t.Errorf("[Test %d] is %d, but was %d", i, test.expected, actual)
        }
    }
}
