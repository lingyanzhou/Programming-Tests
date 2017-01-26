package question309

import (
    "testing"
)

func TestMaxProfit(t *testing.T) {
    cases:= []struct {
        prices []int
        expected int
    } {
            {[]int{1,2}, 1},
            {[]int{1}, 0},
            {[]int{1,0}, 0},
            {[]int{1,2,1,2}, 1},
            {[]int{1,2,0,1,2}, 2},
            {[]int{1,2,20,1,2}, 19},
            {[]int{1,2,1,6,3,5}, 5},
            {[]int{1,3,1,4,3,5}, 4},
            {[]int{1,3,5,5,3,5}, 6},
            {[]int{1,3,5,1,3,5}, 6},
            {[]int{1,3,5,1,2,1,3,5}, 8},
            {[]int{8,5,4,3,2,1,3}, 2},
    }

    for _,c := range cases {
        actual := maxProfit(c.prices)
        if actual!=c.expected {
            t.Errorf("Input: %v, \n\tExpecting %d, \n\tbut was %d", c.prices, c.expected, actual)
        }
    }
}
