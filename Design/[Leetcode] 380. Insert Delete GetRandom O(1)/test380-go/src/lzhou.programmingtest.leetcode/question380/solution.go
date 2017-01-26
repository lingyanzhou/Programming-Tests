package question380

import (
	"math/rand"
)

type RandomizedSet struct {
	indices map[int]int
	list    []int
}

/** Initialize your data structure here. */
func Constructor() RandomizedSet {
	var randomizedSet RandomizedSet
	randomizedSet.indices = make(map[int]int)
	randomizedSet.list = make([]int, 0, 10)
	return randomizedSet
}

/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
func (this *RandomizedSet) Insert(val int) bool {
	_, ok := this.indices[val]
	if ok {
		return false
	}
	this.indices[val] = len(this.list)
	this.list = append(this.list, val)
	return true
}

/** Removes a value from the set. Returns true if the set contained the specified element. */
func (this *RandomizedSet) Remove(val int) bool {
	i, ok := this.indices[val]
	if !ok {
		return false
	}
	lastVal := this.list[len(this.list)-1]
	this.indices[lastVal] = i
	delete(this.indices, val)
	this.list[i] = lastVal
	this.list = this.list[:len(this.list)-1]
	return true
}

/** Get a random element from the set. */
func (this *RandomizedSet) GetRandom() int {
	if len(this.list) == 0 {
		return -1
	}
	i := rand.Intn(len(this.list))
	return this.list[i]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
