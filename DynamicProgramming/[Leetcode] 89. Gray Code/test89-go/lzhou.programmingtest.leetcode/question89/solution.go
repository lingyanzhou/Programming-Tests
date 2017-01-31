package question89

import "math"
/**
 * #Reflected Gray code generation
 * 
 * 1. Create a 2^n int array
 * 2. Initialize the first element to 0. The already generated length `len=1`. Highest bits `m=0`
 * 3. Generate next `len` elements by 
 * 3.1. Copy the previous `len` backwards, ie `nums[0..len]=nums[len*2..len]`
 * 3.2. appending bit 1 at position `m` for newly generated elements.
 */
func grayCode(n int) []int {
    ret:= make([]int, int(math.Pow(float64(2),float64(n))))
    ret[0]=0
    end:=1
    for i:=1; i<=n; i+=1 {
        for j:=end; j<2*end; j+=1 {
            ret[j] = 1<<uint(i-1) + ret[2*end-1-j]
        }
        end=2*end
    }
    return ret
}
