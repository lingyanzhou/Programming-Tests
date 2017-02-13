package question508

type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func findFrequentTreeSum(root *TreeNode) []int {
    table := make(map[int]int)
    
    findFrequentTreeSumHelper(root, &table)
    
    max := 0
    for _,v := range table {
        if v>max {
            max=v
        }
    }
    ret := make([]int, 0)
    for k,v := range table {
        if v==max {
            ret = append(ret, k)
        }
    }
    return ret
}

func findFrequentTreeSumHelper(root *TreeNode, table *map[int]int) int {
    if root==nil {
        return 0
    }
    
    subtreeSum :=root.Val + findFrequentTreeSumHelper(root.Left, table) + findFrequentTreeSumHelper(root.Right, table)

    c,ok:=(*table)[subtreeSum]
    
    if ok {
        (*table)[subtreeSum]=c+1
    } else {
        (*table)[subtreeSum]=1
    }
    return subtreeSum
}
