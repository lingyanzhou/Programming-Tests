package question553

import ("testing"
"strings"
    )

type Test struct {
    nums []int
    expected string
}

var tests []Test = []Test{
    Test{nums:[]int{1}, expected:"1"},
    Test{nums:[]int{1,2}, expected:"1/2"},
    Test{nums:[]int{1,2,3}, expected:"1/(2/3)"},
    Test{nums:[]int{3,2,1}, expected:"3/(2/1)"},
    Test{nums:[]int{3,2,1,1}, expected:"3/(2/1/1)"},
    Test{nums:[]int{3,1,2,1}, expected:"3/(1/2/1)"},
    Test{nums:[]int{2,1,3,1}, expected:"2/(1/3/1)"},
}

func TestSolution(t *testing.T) {
    for i, test := range tests {
        actual := optimalDivision(test.nums)
        if strings.Compare(actual, test.expected)!=0 {
            t.Errorf("[Test %d] is %s, but was %s", i, test.expected, actual)
        }
    }
}
