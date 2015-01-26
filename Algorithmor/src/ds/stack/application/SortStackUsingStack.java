package ds.stack.application;

import java.util.Stack;

public class SortStackUsingStack {
	
	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		s1.push(5);
		s1.push(9);
		s1.push(3);
		s1.push(7);
		s1.push(6);
		s1.push(1);
		
		System.out.println(s1.firstElement());
		
		while(!s1.empty()){
			int temp = s1.pop();
			if(s2.empty()){
				s2.push(temp);
			}else{
				while(temp < s2.peek()){
					s1.push(s2.pop());
				}
				s2.push(temp);
			}
				
			}
		while(!s2.empty()){
			System.out.println(s2.pop());
		}
			
		}

}
