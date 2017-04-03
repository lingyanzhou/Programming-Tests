package question514

import (
"math"
)

func findRotateSteps(ring string, key string) int {
    prev :=make([]int, len(ring))
    next :=make([]int, len(ring))
    for i, _ := range prev {
        prev[i] = math.MaxInt32
    }
    prev[0] = 0
    
    for i, _ := range next {
        next[i] = math.MaxInt32
    }
    
    matchedLen := 0
    ringLen := len(ring)
    keyLen := len(key)
    for matchedLen<keyLen {
        for i,v := range prev {
            if v!=math.MaxInt32 {
                for j:=0; j<ringLen; j+=1 {
                    realRingIndex := (i+j)%ringLen
                    if ring[realRingIndex]==key[matchedLen] {
                        next[realRingIndex]=int(math.Min(float64(next[realRingIndex]), float64(1+j+prev[i])))
                    }
                }
                for j:=0; j<ringLen; j+=1 {
                    realRingIndex := (i-j+ringLen)%ringLen
                    if ring[realRingIndex]==key[matchedLen] {
                        next[realRingIndex]=int(math.Min(float64(next[realRingIndex]), float64(1+j+prev[i])))
                    }
                }
            }
        }
        matchedLen += 1
        copy(prev, next)
        for i, _ := range next {
            next[i] = math.MaxInt32
        }
    }
    result :=math.MaxInt32
    for _, v := range prev {
        result = int(math.Min(float64(result), float64(v)))
    }
    return result
}
