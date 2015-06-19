package rough;

import java.util.Stack;

public class Q2 {
	
	public static String remDup(String str) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            if(stack.empty()){
                stack.push(str.charAt(i));
            }else if(str.charAt(i)==stack.peek()){
                stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }
        char[] c = new char[stack.size()];
        int i=0;
        while(!stack.empty()){
            c[i++]=stack.pop();
        }
      
      String s = new String(c);
       return s;
  }

	public static void main(String[] args) {
    String x = remDup("ABCCBCBA");
    System.out.println(x);
	}

}
