package ds.stack.application;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionCalculator {
	static Stack<String> operators = new Stack<String>();
	static Stack<Integer> operands = new Stack<Integer>();
	
	public static void calculate(String expression){
		StringTokenizer st = new StringTokenizer(expression," ");
		while(st.hasMoreTokens()){
			   String token = st.nextToken();
			   if(token.equals("/")||token.equals("*")||token.equals("+")||token.equals("-")){
				   operators.push(token);
			   }else if(!token.equals("(") && !token.equals(")")){
				   operands.push(Integer.parseInt(token));
			   }
			}
		
	while(!operators.empty()&& operands.size()>1){
		   operands.push(operation(operators.pop(),operands.pop(),operands.pop()));
		}
	    if(operands.empty()){
	    	System.out.println("Can't process expression");
	    }else{
		    System.out.println(expression+" evaluates to "+operands.pop());
	    }
	}
	
	public static int operation(String c, int a, int b){
		int result=0;
		switch (c){
		case "+":
			result = a+b;
			break;
		case "-":
			result = a-b;
			break;
		case "*":
			result = a*b;
			break;
		case "/":
			result = a/b;
			break;
		}
		return result;		
	}
	
	public static void main(String[] args){
		ExpressionCalculator.calculate("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) * 7 ) 3 )");
	}

}
