package question89

import "testing"

type TestData struct {
    n int
    expected []int
}
var tests []TestData = []TestData{
    TestData{1, []int{0,1}},
    TestData{2, []int{0, 1,3,2}},
    TestData{3, []int{0,1,3,2,6,7,5,4}},
}

func Test_grayCode_1(t *testing.T) {
    for _, test:= range tests {
        actual:=grayCode(test.n)
        if len(actual)!=len(test.expected) {
            t.Errorf("The length is %d \n\t but was %d\n", len(test.expected), len(actual))
        }
        for i, _ := range actual {
            if actual[i]!=test.expected[i] {
                t.Errorf("The element at %d is %d \n\t but was %d\n", i, test.expected[i], actual[i])
            }
        } 
    }
}

