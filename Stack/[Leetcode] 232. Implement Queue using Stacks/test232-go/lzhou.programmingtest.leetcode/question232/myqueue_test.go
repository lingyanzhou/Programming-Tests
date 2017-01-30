package question232

import "testing"

func Test_1(t *testing.T) {
    myqueue:=Constructor()
    myqueueptr := &myqueue
    if !myqueueptr.Empty() {
        t.Fail()
    }
    myqueueptr.Push(1)
    if myqueueptr.Peek()!=1 {
        t.Fail()
    }
    if myqueueptr.Empty() {
        t.Fail()
    }
    myqueueptr.Push(2)
    if myqueueptr.Peek()!=1 {
        t.Fail()
    }
    if myqueueptr.Pop()!=1 {
        t.Fail()
    }
    if myqueueptr.Pop()!=2 {
        t.Fail()
    }
    if !myqueueptr.Empty() {
        t.Fail()
    }
}

func Test_2(t *testing.T) {
    myqueue:=Constructor()
    myqueueptr := &myqueue
    if !myqueueptr.Empty() {
        t.Fail()
    }
    myqueueptr.Push(1)
    if myqueueptr.Peek()!=1 {
        t.Fail()
    }
    if myqueueptr.Empty() {
        t.Fail()
    }
    if myqueueptr.Pop()!=1 {
        t.Fail()
    }
    if !myqueueptr.Empty() {
        t.Fail()
    }
}


func Test_3(t *testing.T) {
    myqueue:=Constructor()
    myqueueptr := &myqueue
    if !myqueueptr.Empty() {
        t.Fail()
    }
    myqueueptr.Push(1)
    if myqueueptr.Peek()!=1 {
        t.Fail()
    }
    if myqueueptr.Empty() {
        t.Fail()
    }
    if myqueueptr.Pop()!=1 {
        t.Fail()
    }
    if !myqueueptr.Empty() {
        t.Fail()
    }
    myqueueptr.Push(2)
    if myqueueptr.Peek()!=2 {
        t.Fail()
    }
    if myqueueptr.Empty() {
        t.Fail()
    }
    if myqueueptr.Pop()!=2 {
        t.Fail()
    }
    if !myqueueptr.Empty() {
        t.Fail()
    }
}
