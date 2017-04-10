# [careercup] 5720947240730624
[Link](https://www.careercup.com/question?id=5720947240730624)

##Question:

Using the following:
 
```java
public static Func<int, int> Y(Func<Func<int, int>, Func<int, int>> f)
{
	return x => f(Y(f))(x);
}
```

Create a Func<int, int> which computes the n-th fibonacci number using only anonymous lambdas.

-----------------------

##Solution:
 
We simply make f ignore its argument and constantly produce fibonaci function:
 	`f(y) = fib`.

Then, `Y(f) = f(Y(f))=fib`.
