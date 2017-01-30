package question232


/*****************************/
/******** Stack ************/
type Stack struct {
    data []int
}

func NewStack() *Stack {
    return new(Stack)
}

func (this *Stack) Size() (size int) {
    return len(this.data)
}

func (this *Stack) Pop() (head int, ok bool) {
    ok=false
    head=0
    if len(this.data)==0 {
        return head, ok
    }
    
    ok=true
    head = this.data[len(this.data)-1]
    this.data=this.data[:len(this.data)-1]
    return head, ok
}

func (this *Stack) Peek() (head int, ok bool){
    ok=false
    head=0
    if len(this.data)==0 {
        return head, ok
    }
    
    ok=true
    head = this.data[len(this.data)-1]
    return head, ok
}

func (this *Stack) Push(val int) {
    this.data = append(this.data, val)
}

/*****************************/
/******** MyQueue ************/

type MyQueue struct {
    stack1 *Stack
    stack2 *Stack
}


/** Initialize your data structure here. */
func Constructor() MyQueue {
    ret:= MyQueue{stack1: new(Stack), stack2: new(Stack)}
    return ret
}


/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int)  {
    this.stack1.Push(x)
}


/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() (head int) {
    if this.stack2.Size()==0 {
        for this.stack1.Size()>0 {
            v, _:= this.stack1.Pop()
            this.stack2.Push(v)
        }
    }
    head=0
    if (this.stack2.Size()==0) {
        return head
    }
    head,_ = this.stack2.Peek()
    this.stack2.Pop()
    return head
}


/** Get the front element. */
func (this *MyQueue) Peek() (head int) {
    if this.stack2.Size()==0 {
        for this.stack1.Size()>0 {
            v, _:= this.stack1.Pop()
            this.stack2.Push(v)
        }
    }
    head=0
    if (this.stack2.Size()==0) {
        return head
    }
    head,_ = this.stack2.Peek()
    return head
}


/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
    return this.stack1.Size()==0 && this.stack2.Size()==0
}




/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
