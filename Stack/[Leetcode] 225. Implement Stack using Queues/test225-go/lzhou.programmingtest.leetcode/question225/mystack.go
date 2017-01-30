package question225

import "container/list"

type MyQueue struct {
	data *list.List
}

func NewQueue() *MyQueue {
	q := new(MyQueue)
	q.data = list.New()
	return q
}

func (this *MyQueue) Len() int {
	return this.data.Len()
}

func (this *MyQueue) Offer(val interface{}) {
	this.data.PushBack(val)
}

func (this *MyQueue) Peek() interface{} {
	if 0 == this.data.Len() {
		return nil
	}
	if v := this.data.Front(); v == nil {
		return nil
	} else {
		return v.Value
	}
}

func (this *MyQueue) Poll() interface{} {
	if 0 == this.data.Len() {
		return nil
	}
	if v := this.data.Front(); v == nil {
		return nil
	} else {
		return this.data.Remove(v)
	}
}

/**********************/

type MyStack struct {
	queue1 *MyQueue
	queue2 *MyQueue
}

/** Initialize your data structure here. */
func Constructor() MyStack {
	var ret MyStack
	ret.queue1 = NewQueue()
	ret.queue2 = NewQueue()
	return ret
}

/** Push element x onto stack. */
func (this *MyStack) Push(x int) {
	this.queue2.Offer(x)
	for this.queue1.Len() > 0 {
		this.queue2.Offer(this.queue1.Poll())
	}
	this.queue1, this.queue2 = this.queue2, this.queue1
}

/** Removes the element on top of the stack and returns that element. */
func (this *MyStack) Pop() int {
	v, ok := this.queue1.Poll().(int)
	if ok {
		return v
	} else {
		return 0
	}
}

/** Get the top element. */
func (this *MyStack) Top() int {
	v, ok := this.queue1.Peek().(int)
	if ok {
		return v
	} else {
		return 0
	}
}

/** Returns whether the stack is empty. */
func (this *MyStack) Empty() bool {
	return this.queue1.Len() == 0
}

/**
 * Your MyStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Empty();
 */
