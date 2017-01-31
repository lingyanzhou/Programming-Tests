package question52

import "testing"

var tests [][]int = [][]int{[]int{1,1}, []int{2,0}, []int{3,0}, []int{4,2}, []int{8,92}}

func Test_TotalNQueens_1(t *testing.T) {
    for i, test:= range tests {
        actual := totalNQueens(test[0])
        if actual!=test[1] {
            t.Errorf("[Test %d] is %d was %d", i, test[1], actual)
        }
    }
}
