package question371

import (
    "math"
    "runtime"
)

func numbersByRecursion(n int) []int {
    runtime.GOMAXPROCS(4)
    ret := make([]int, int(math.Pow10(n))-1)
    numbersByRecursionHelper(1, n, ret)
    return ret
}

func numbersByRecursionHelper(m int, n int, nums []int) {
    if m>n {
        return
    }
    start:=int(math.Pow10(m-1))-1
    end:=int(math.Pow10(m))-1
    c := make(chan int, 4)
    for j:=0; j<4; j+=1 {
        go func(jj int) {
            for i:=start+jj; i<end; i+=4 {
                nums[i]= i+1;
            }
            c<-1
        }(j)
    }
    for j:=0; j<4; j+=1 {
        <-c
    }
    numbersByRecursionHelper(m+1, n, nums)
}
