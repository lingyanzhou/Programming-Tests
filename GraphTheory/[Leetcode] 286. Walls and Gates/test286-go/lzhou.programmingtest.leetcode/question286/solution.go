package question286

import (
    "container/list"
    "math"
)

const (
    INF = math.MaxInt32
)

func wallsAndGates(rooms [][]int) {
    n:=len(rooms)
    if n==0 {
        return
    }
    m:=len(rooms[0])
    if m==0 {
        return
    }
    
    queue:= list.New()
    queue.Init()

    for i, r := range rooms {
        for j, v := range r {
            if v==0 {
                queue.PushBack([]int{i, j})
            }
        }
    }

    for queue.Len()>0 {
        e := queue.Front()
        p := queue.Remove(e).([]int)
        v := rooms[p[0]][p[1]]
        if p[0]-1>=0 && rooms[p[0]-1][p[1]]==INF {
            rooms[p[0]-1][p[1]] = v+1
            queue.PushBack([]int{p[0]-1, p[1]})
        }
        if p[0]+1<n && rooms[p[0]+1][p[1]]==INF {
            rooms[p[0]+1][p[1]] = v+1
            queue.PushBack([]int{p[0]+1, p[1]})
        }
        if p[1]-1>=0 && rooms[p[0]][p[1]-1]==INF {
            rooms[p[0]][p[1]-1] = v+1
            queue.PushBack([]int{p[0], p[1]-1})
        }
        if p[1]+1<m && rooms[p[0]][p[1]+1]==INF {
            rooms[p[0]][p[1]+1] = v+1
            queue.PushBack([]int{p[0], p[1]+1})
        }
    }
}
