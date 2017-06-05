package algo.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllStringPalindromicPartitions {
	
	public static boolean isPalindrome(String s,int start, int end){
		if(end == start){
			return true;
		}

		while(start < end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void findAllPalindromePartitions(String s, int lo, int hi, List<List<String>> result, List<String> curr){
		
		// If the pointer has reached the end then no further substring left to analyze
		// Add the current partitions to the result
		if(lo >= hi){
			List<String> add = new ArrayList<String>();
			add.addAll(curr);
			result.add(add);
			return;
		}
		
		// Pick all possible ending point for substrings starting from index lo
		for(int i=lo;i<hi;i++){
			// Check if a substring is a palindrome
			if(isPalindrome(s,lo,i)){
				
				//Add to the current list of partitions
				curr.add(s.substring(lo,i+1));
				
				// recurse for the remaining part of the string
				findAllPalindromePartitions(s,lo+1,hi,result,curr);
				
				// Remove the current palindrome from curr for backtracking
				curr.remove(curr.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> curr = new LinkedList<String>();
		String s = "geeks";
		
		findAllPalindromePartitions(s,0,5,result,curr);
		
		for(List<String> partition : result){
			for(String t : partition){
				System.out.print(t+" ");
			}
			System.out.println("");
		}
	}

}
