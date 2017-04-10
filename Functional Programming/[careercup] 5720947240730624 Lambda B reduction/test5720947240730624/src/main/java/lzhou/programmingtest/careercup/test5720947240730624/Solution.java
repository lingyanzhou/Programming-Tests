package lzhou.programmingtest.careercup.test5720947240730624;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Solution 
{
    public static Function<Integer, Integer> Y(Function<Function<Integer, Integer>, Function<Integer, Integer>> f) {
		return x -> f.apply(Y(f)).apply(x);
	}

    public int calcFibonaci(int n) {
        //Write your code here
		Function<Integer, Integer> fib = Y(
				func -> x -> {
			if (x < 2)
				return x;
			else
				return func.apply(x - 1) + func.apply(x - 2);
		});
        return fib.apply(n);
    }
}
