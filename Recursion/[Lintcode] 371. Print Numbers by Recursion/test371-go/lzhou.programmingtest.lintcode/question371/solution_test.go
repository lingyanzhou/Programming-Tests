package question371

import (
    "testing"
    "math"
)
var data[]int = []int{1,2,3,4,5,6,7}

func Test_numbersByRecursion(t *testing.T) {
    for ti, n:= range data {
        actual := numbersByRecursion(n)
        expectedLen:= int(math.Pow10(n)-1)
        if len(actual)!=expectedLen {
            t.Errorf("[Test %d], Array size is %d\n\t but was %d", ti, expectedLen, len(actual))
        }
        for i,v:=range actual {
            if v!=i+1 {
                t.Errorf("[Test %d] Index %d is %d\n\t but was %d", ti, i, i+1, v)
            }
        }
    }
}

