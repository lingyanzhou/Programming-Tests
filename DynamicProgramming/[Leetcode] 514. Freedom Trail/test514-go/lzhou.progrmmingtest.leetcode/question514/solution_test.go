package question514

import (
"testing"
)

type TestCase struct {
    ring string
    key string
    expected int
}

var testcases []TestCase = []TestCase{
    TestCase{"a","a",1},
    TestCase{"abc","aaa",3},
    TestCase{"abc","b",2},
    TestCase{"abc","c",2},
    TestCase{"abcabca","c",3},
    TestCase{"abbcabca","c",3},
    TestCase{"abcde","adbac",12},
    TestCase{"lbvunlreahavdiquuwwdgmfexppliqldnxpqbvssobjtnlmfabxcnbngwpskkuwmpanmapqigiskaktkozycqkzfayyzsssxytmc",
             "cwvqialwpaxbbmenxzdnfsqitvblnxdpznhxwvcqatwosypgislujdznyflgsqmikkspscuaubmykpaqergaoybtfsmpmlkkuakn",
             988},
}

func TestSolution(t *testing.T) {
    for i,tc := range testcases {
        actual := findRotateSteps(tc.ring, tc.key)

        if actual!=tc.expected {
            t.Errorf("[Test %d] is %d, but was %d", i, tc.expected, actual)
        }
    }
}
