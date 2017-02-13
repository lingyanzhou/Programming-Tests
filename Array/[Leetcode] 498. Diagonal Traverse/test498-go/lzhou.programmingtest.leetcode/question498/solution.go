package question498

func findDiagonalOrder(matrix [][]int) []int {
    ret := make([]int, 0)
    n := len(matrix)
    if n==0 {
        return ret
    }
    m := len(matrix[0])
    if m==0 {
        return ret
    }
    ret = make([]int, m*n)
    
    for i,j,p,q:=0,0,0,0; i<m*n; i+=1 {
        ret[i] = matrix[p][q]
        if j%2==0 {
            p-=1;
            q+=1;
        } else {
            p+=1;
            q-=1;
        }
        if p>=n {
            q += 2
            p = n-1
            j+=1
            continue
        }
        if q>=m {
            p+=2
            q=m-1
            j+=1
            continue
        }
        if p<0 {
            p=0
            j+=1
            continue
        }
        if q<0 {
            q=0
            j+=1
            continue
        }
    }
    return ret
}
