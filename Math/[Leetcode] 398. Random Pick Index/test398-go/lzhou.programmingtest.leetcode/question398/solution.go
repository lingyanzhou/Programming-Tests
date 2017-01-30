package question398

import (
    "math/rand"
)

type Solution struct {
    nums []int
}

func New(n[] int) *Solution {
    return &Solution{nums: n}
}

func (this *Solution) pick(k int) (index int) {
    count := 0
    index = 0
    for i, v:=range this.nums {
        if v==k {
            if  0==rand.Intn(count) {
                index = i
            }
            count+=1
        }
    }
    return index
}
