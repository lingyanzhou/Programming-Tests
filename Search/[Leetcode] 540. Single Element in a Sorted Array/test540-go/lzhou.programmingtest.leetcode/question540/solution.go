package question540;

func singleNonDuplicate(nums []int) int {
    if len(nums)==1 {
        return nums[0];
    }
    pairCount := len(nums)/2;
    rightPair := pairCount-1;
    leftPair := 0;
    for rightPair>=leftPair {
        mid := (rightPair+leftPair)/2;
        if nums[mid*2]==nums[mid*2+1] {
            leftPair=mid+1;
        } else {
            rightPair=mid-1;
        }
    }
    return nums[2*leftPair];
}
