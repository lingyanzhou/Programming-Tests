package question40

func CombinationSum3(k int, n int) [][]int {
    ret := combinationSum3Helper(k, n, 1, make([]int, 0, k), make([][]int, 0, 10))
    return ret
}

func combinationSum3Helper(k int, n int, start int, partial []int, result [][]int) [][]int{
    if k==0 && n==0 {
        tmp:=make([]int, len(partial))
        copy(tmp, partial)
        result = append(result, tmp)
        return result
    }
    if k==0 || n<0 {
        return result
    }
    for i:=start; i<=10-k; i+=1 {
        partial = append(partial, i)
        result = combinationSum3Helper(k-1, n-i, i+1, partial, result)
        partial = partial[:len(partial)-1]
    }
    return result
}
