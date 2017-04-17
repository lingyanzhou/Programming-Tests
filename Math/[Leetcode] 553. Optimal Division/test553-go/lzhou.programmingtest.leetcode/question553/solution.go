package question553

import ("strconv")

func optimalDivision(nums []int) string {
    if (len(nums)==0) {
        return ""
    } else if len(nums)==1 {
        return strconv.Itoa(nums[0])
    } else if len(nums)==2 {
        return strconv.Itoa(nums[0])+"/"+strconv.Itoa(nums[1])
    } else{
        result := strconv.Itoa(nums[0])
        result += "/("
        
        for i:= 1; i<len(nums)-1; i+=1 {
            result += strconv.Itoa(nums[i])
            result += "/"
        }
        
        result += strconv.Itoa(nums[len(nums)-1])
        result += ")"
        
        return result
    }
}
