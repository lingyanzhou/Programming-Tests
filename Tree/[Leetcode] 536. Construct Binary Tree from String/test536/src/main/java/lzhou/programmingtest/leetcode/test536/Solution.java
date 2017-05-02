package lzhou.programmingtest.leetcode.test536;

public class Solution 
{
	public TreeNode str2tree(String s) {
		TreeNode tree = null;
            System.out.println(s);
		if (s.length()>0) {
			ParseReturn token1 = parseFirstToken(s);
			tree = token1.value;
			int end = token1.consumed;
			if (token1.consumed!=s.length()) {
				end = pairedParenthesisIndex(token1.consumed, s);
				tree.left = str2tree(s.substring(token1.consumed+1, end-1));
			}

			if (end!=s.length()) {
				int end2 = pairedParenthesisIndex(end, s);
				tree.right = str2tree(s.substring(end+1, end2-1));
			}
		}
		return tree;
	}
	
	public String tree2str(TreeNode root) {
		if (root==null) {
			return "";
		}
		String ret = Integer.toString(root.val);
		if (root.left==null && root.right==null) {
		} else if (root.left!=null && root.right==null) {
			ret += "(";
			ret += tree2str(root.left);
			ret += ")";
		} else if (root.left==null && root.right!=null) {
			ret += "()(";
			ret += tree2str(root.right);
			ret += ")";
		} else {
			ret += "(";
			ret += tree2str(root.left);
			ret += ")(";
			ret += tree2str(root.right);
			ret += ")";
		}
		return ret;
	}
	
	private int pairedParenthesisIndex(int start, String s) {
		int i=start;
		int parenthesisOpened = 0;
		if (start!=s.length()) {
			char c = s.charAt(i);
			assert c=='(';
			i+=1;
			parenthesisOpened=1;
		}
			
		while (i<s.length() && parenthesisOpened!=0) {
			char c = s.charAt(i);
			i+=1;
			
			switch (c) {
			case '(':
				parenthesisOpened+=1;
				break;
			case ')':
				parenthesisOpened-=1;
				break;
			default:
			}
		}
		return i;
	}

	private ParseReturn parseFirstToken(String s) {
		int consumed = 0;
		int val=0;
		int sign = 1;
		boolean done = false;
		while (!done && consumed<s.length()) {
			char c = s.charAt(consumed);
			switch (c) {
			case '-':
				consumed+=1;
				sign=-1;
				break;
			case '(':
				done=true;
				break;
			case ')':
				throw new RuntimeException();
			default:
				consumed+=1;
				val += Character.digit(c, 10);
			}
		}
		if (consumed==0) {
			return new ParseReturn(consumed, null);
		} 
		return new ParseReturn(consumed, new TreeNode(sign*val));
	}
	
	private class ParseReturn {
		int consumed;
		TreeNode value;
		
		ParseReturn(int consumed, TreeNode value) {
			this.consumed=consumed;
			this.value=value;
		}
	}
}


