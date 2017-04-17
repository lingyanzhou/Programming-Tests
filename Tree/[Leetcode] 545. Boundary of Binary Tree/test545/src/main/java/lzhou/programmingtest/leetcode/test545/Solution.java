package lzhou.programmingtest.leetcode.test545;

import java.util.*;

public class Solution 
{
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> boundary = new ArrayList<Integer>();
		if (root==null) {
			return boundary;
		}
		stack.push(root);
		followLeftBoundary(boundary, stack);
		followBottomBoundary(boundary, stack);
		stack.clear();
		stack.push(root);
		followRightBoundary(boundary, stack);
		return boundary;
	}
	
	private void followLeftBoundary(List<Integer> boundary, Stack<TreeNode> stack) {
		assert stack.size()>0;
		TreeNode root = stack.pop();
		boundary.add(root.val);

		if (root.right!=null) {
			stack.push(root.right);
		}
		if (root.left==null) {
			return;
		}
		stack.push(root.left);
		followLeftBoundaryHelper(boundary, stack);
	}
	
	private void followLeftBoundaryHelper(List<Integer> boundary, Stack<TreeNode> stack) {
		assert stack.size()>0;
		TreeNode node = stack.pop();
		boundary.add(node.val);
		if (node.left==null && node.right==null) {
			return;
		} else {
			if (node.right!=null) {
				stack.push(node.right);
			}
			if (node.left!=null) {
				stack.push(node.left);
			}
			followLeftBoundaryHelper(boundary, stack);
		}
	}
	
	private void followBottomBoundary(List<Integer> boundary, Stack<TreeNode> stack) {
		if (stack.isEmpty()) {
			return;
		}
		TreeNode node = stack.pop();
		if (node.left==null && node.right==null) {
			boundary.add(node.val);
			followBottomBoundary(boundary, stack);
		} else {
			if (node.right!=null) {
				stack.push(node.right);
			}
			if (node.left!=null) {
				stack.push(node.left);
			}
			followBottomBoundary(boundary, stack);
		}
	}
	
	private void followRightBoundary(List<Integer> boundary, Stack<TreeNode> stack) {
		assert stack.size()>0;
		TreeNode root = stack.pop();
		
		if (root.right==null) {
			return;
		}
		stack.push(root.right);
		followRightBoundaryHelper(boundary, stack);
	}
	
	private void followRightBoundaryHelper(List<Integer> boundary, Stack<TreeNode> stack) {
		assert stack.size()>0;
		TreeNode node = stack.peek();
		if (node.left==null && node.right==null) {
			stack.pop();
			followRightBoundaryStackPoper(boundary, stack);
		} else {
			if (node.right!=null) {
				stack.push(node.right);
			} else if (node.left!=null) {
				stack.push(node.left);
			}
			followRightBoundaryHelper(boundary, stack);
		}
	}
	
	private void followRightBoundaryStackPoper(List<Integer> boundary, Stack<TreeNode> stack) {
		while (stack.size()>0) {
			boundary.add(stack.pop().val);
		}
	}
}
