package algo.backtracking;

/*
 * http://www.geeksforgeeks.org/remove-invalid-parentheses/
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParantheses {
	
	public static void removeInvalidParenthesis(String s){
		Deque<String> q = new ArrayDeque<String>();
		HashSet<String> visited = new HashSet<String>();
		
		q.add(s);
		visited.add(s);
		boolean valid = false;
		while(!q.isEmpty()){
			String str = q.remove();
			if(isValid(str)){
				System.out.println(str);
				valid = true;
			}
				
			if(valid){
				continue;
			}
				
			for(int i=0;i<str.length();i++){
				if(str.charAt(i) != '(' && str.charAt(i) != ')'){
					continue;
				}
				
				String next = str.substring(0,i)+str.substring(i+1);
				if(!visited.contains(next)){
					//removeParantheses(next);
					visited.add(next);
					q.add(next);
				}
			}
		}
	}
	
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='('){
				stack.push(c);
			}
			if(c == ')'){
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String expression = "()()a)()";
	    removeInvalidParenthesis(expression);
	}

}
