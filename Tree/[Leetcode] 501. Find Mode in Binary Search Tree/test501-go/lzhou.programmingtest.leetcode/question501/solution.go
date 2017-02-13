package question501

import (
    "math"
    "fmt"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findMode(root *TreeNode) []int {
    if root==nil {
        return make([]int, 0)
    }
    val, valCount, modeCount, modes := findModeHelper(root, 0, 0, 0, make([]int, 0))
    //fmt.Println("==4==", root.Val, val, valCount, modeCount, modes)
    _, modes = tryAddMode(val, valCount, modeCount, modes)
    return modes
}

func findModeHelper(root *TreeNode, val int, valCount int, modeCount int, modes []int) (int , int, int, []int) {
    if root==nil {
        return val, valCount, modeCount, modes
    }
    
    //fmt.Println("==1==", root.Val, val, valCount, modeCount, modes)
    
    //fmt.Println("leftDown")
    leftVal, leftValCount, leftModeCount, leftModes := findModeHelper(root.Left, val, valCount, modeCount, modes)
    //fmt.Println("rightUp")
    if leftValCount!=0 {
        val = root.Val
        modeCount = leftModeCount
        modes = leftModes
        if leftVal==root.Val {
            valCount = leftValCount + 1
            //fmt.Println("==5==")
        } else {
            modeCount, modes = tryAddMode(leftVal, leftValCount, leftModeCount, leftModes)
            valCount = 1
        }
    } else {
        val = root.Val
        valCount = 1
    }
    //fmt.Println("==2==", root.Val, val, valCount, modeCount, modes)
    
    if root.Right==nil {
        return val, valCount, modeCount, modes
    }
    //fmt.Println("==3==", root.Val, val, valCount, modeCount, modes)
    //fmt.Println("rightDown")
    //defer fmt.Println("leftUp")
    return findModeHelper(root.Right, val, valCount, modeCount, modes)
}

func tryAddMode(val int, valCount int, modeCount int, modes []int) (int, []int) {
    if valCount<modeCount {
        return modeCount, modes
    }
    if valCount>modeCount {
        modes = nil
        modes = append(modes, val)
        return valCount, modes
    } 
    
    modes = append(modes, val)
    return valCount, modes
}
