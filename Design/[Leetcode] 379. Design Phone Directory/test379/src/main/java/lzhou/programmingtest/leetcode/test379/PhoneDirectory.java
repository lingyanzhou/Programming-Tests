package lzhou.programmingtest.leetcode.test379;

import java.util.*;

/**
 * 
 *
 */
public class PhoneDirectory {
	boolean[] used;
	int maxNumbers;
	Queue<Integer> released;
	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone
	 *            directory.
	 */
	public PhoneDirectory(int maxNumbers) {
		released = new LinkedList<Integer>();
		used = new boolean[maxNumbers];
		this.maxNumbers = maxNumbers;
		for (int i=1; i<=maxNumbers; ++i) {
			released.offer(i);
		}
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		if (released.isEmpty()) {
			return -1;
		}
		int ret = released.poll();
		used[ret-1]=true;
		return ret;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		if (number>maxNumbers || number<1) {
			return false;
		}
		return !used[number-1];
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (used[number-1]) {
			used[number-1]=false;
			released.offer(number);
		}
	}
}
