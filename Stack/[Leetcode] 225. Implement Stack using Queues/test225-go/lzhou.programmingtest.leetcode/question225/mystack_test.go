package question225

import "testing"

func Test_1(t *testing.T) {
	mystack := Constructor()
	mystackptr := &mystack
	if !mystackptr.Empty() {
		t.Fail()
	}
	mystackptr.Push(1)
	if mystackptr.Top() != 1 {
		t.Fail()
	}
	if mystackptr.Empty() {
		t.Fail()
	}
	mystackptr.Push(2)
	if mystackptr.Top() != 2 {
		t.Fail()
	}
	if mystackptr.Pop() != 2 {
		t.Fail()
	}
	if mystackptr.Pop() != 1 {
		t.Fail()
	}
	if !mystackptr.Empty() {
		t.Fail()
	}
}

func Test_2(t *testing.T) {
	mystack := Constructor()
	mystackptr := &mystack
	if !mystackptr.Empty() {
		t.Fail()
	}
	mystackptr.Push(1)
	if mystackptr.Top() != 1 {
		t.Fail()
	}
	if mystackptr.Empty() {
		t.Fail()
	}
	if mystackptr.Pop() != 1 {
		t.Fail()
	}
	if !mystackptr.Empty() {
		t.Fail()
	}
}

func Test_3(t *testing.T) {
	mystack := Constructor()
	mystackptr := &mystack
	if !mystackptr.Empty() {
		t.Fail()
	}
	mystackptr.Push(1)
	if mystackptr.Top() != 1 {
		t.Fail()
	}
	if mystackptr.Empty() {
		t.Fail()
	}
	if mystackptr.Pop() != 1 {
		t.Fail()
	}
	if !mystackptr.Empty() {
		t.Fail()
	}
	mystackptr.Push(2)
	if mystackptr.Top() != 2 {
		t.Fail()
	}
	if mystackptr.Empty() {
		t.Fail()
	}
	if mystackptr.Pop() != 2 {
		t.Fail()
	}
	if !mystackptr.Empty() {
		t.Fail()
	}
}
