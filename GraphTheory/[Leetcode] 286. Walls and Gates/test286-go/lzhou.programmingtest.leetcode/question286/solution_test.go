package question286

import (
    "testing"
)

type TestData struct {
    rooms [][]int
    expected [][]int
}


var testcases []TestData = []TestData {
    TestData{rooms: [][]int{[]int{INF, -1, 0, INF}},
             expected: [][]int{[]int{INF, -1, 0, 1}}},
    TestData{rooms: [][]int{[]int{0, INF, INF, INF, 0}},
             expected: [][]int{[]int{0, 1, 2, 1, 0}}},
    TestData{rooms: [][]int{[]int{0, INF, INF, 0}},
             expected: [][]int{[]int{0, 1, 1, 0}}},
    TestData{rooms: [][]int{[]int{INF, -1, 0, INF},
                            []int{0, -1, INF, INF}},
             expected: [][]int{[]int{1, -1, 0, 1},
                               []int{0, -1, 1, 2}}},
    TestData{rooms: [][]int{[]int{INF, INF, 0, INF},
                            []int{INF, -1, INF, -1},
                            []int{INF, -1, INF, -1},
                            []int{0, -1, INF, INF}},
             expected: [][]int{[]int{2, 1, 0, 1},
                               []int{2, -1, 1, -1},
                               []int{1, -1, 2, -1},
                               []int{0, -1, 3, 4}}},
}

func Test_wallsAndGates(t *testing.T) {
    for ti, tc:= range testcases {
        wallsAndGates(tc.rooms)
        for i, r := range tc.rooms {
            for j, v := range r {
                if v!=tc.expected[i][j] {
                    t.Errorf("[Test %d] is %d but was %d\n", ti, tc.expected[i][j], v)
                }
            }
        }
    }
}
