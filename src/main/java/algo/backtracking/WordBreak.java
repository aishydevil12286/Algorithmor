package algo.backtracking;

/*
 * http://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 */

import java.util.HashSet;

public class WordBreak {
	
	public static void wordBreak(String s,HashSet<String> dict,StringBuffer result){
		int N = s.length();
		
		if(s.equals("")){
			System.out.println(result.toString());
			return;
		}
		
		for(int i=1;i<=N;i++){
			if(dict.contains(s.substring(0,i))){
				// Add this word to result
				result.append(s.substring(0,i)).append(" ");
				
				// recur for the rest of the string
				wordBreak(s.substring(i),dict,result);
				
				result.setLength(result.length()-i-1);
			}
		}
	}
	
	public static void main(String[] args){
		HashSet<String> dict = new HashSet<String>(); 
		dict.add("mobile");
		dict.add("samsung");
		dict.add("sam");
		dict.add("sung");
		dict.add("man");
		dict.add("mango");
		dict.add("icecream");
		dict.add("and");
		dict.add("go");
		dict.add("i");
		dict.add("love");
		dict.add("ice");
		dict.add("cream");
		
		String s = "iloveicecreamandmango";
		
		wordBreak(s,dict,new StringBuffer());		
	}
}
