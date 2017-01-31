package question52

func totalNQueens(n int) int {
    colMap := make(map[int]bool)
    diaMap := make(map[int]bool)
    rdiaMap := make(map[int]bool)
    
    return totalNQueensHelper(n, 1, colMap, diaMap, rdiaMap)
}

func totalNQueensHelper(n int, m int, colMap map[int]bool, diaMap map[int]bool, rdiaMap map[int]bool) (total int) {
    total = 0
    if m>n {
        total=1
        return total
    }
    for i:=1; i<=n; i+=1 {
        if _, ok := colMap[i]; ok {
            continue
        }
        if _, ok := diaMap[i-m]; ok {
            continue
        }
        if _, ok := rdiaMap[i+m]; ok {
            continue
        }
        colMap[i]=true
        diaMap[i-m]=true
        rdiaMap[i+m]=true
        total+= totalNQueensHelper(n, m+1, colMap, diaMap, rdiaMap)
        delete(colMap, i)
        delete(diaMap, i-m)
        delete(rdiaMap, i+m)
    }
    return total
}
