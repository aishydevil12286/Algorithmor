package algo.backtracking;

/* 
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */

import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
	
	public static void permute(char[] s, int[] count, char[] result, int level){
		if(level == result.length){
			System.out.println(new String(result));
		}
		
		for(int i=0;i<s.length;i++){
			// If the char is already used 
			// then use the next available character 
			if(count[i]==0){
				continue;
			}
			// add the character to the result
			result[level] = s[i];
			// reduce one count for the character used
			count[i]--;
			// Permute for the next level
			permute(s,count,result,level+1);
			// Reset the count back for back propagation
			count[i]++;
		}
	}
	
	public static void permuteString(String s){
		Map<Character,Integer> frequency = new TreeMap<>();
		for(int i=0;i<s.length();i++){
			Integer f = frequency.get(s.charAt(i));
			if(f==null){
				frequency.put(s.charAt(i),1);
			}else{
				frequency.put(s.charAt(i),f+1);
			}
		}
		
		char[] chars = new char[frequency.size()];
		int[]  counts     = new int[frequency.size()];
		int j=0;
		
		for(Map.Entry<Character,Integer> entry : frequency.entrySet()){
			chars[j]=entry.getKey();
			counts[j++]=entry.getValue();
		}
		char[] result = new char[s.length()];
		permute(chars,counts,result,0);
	}
	
	public static void main(String[] args){
		String s = "AABCD";
		permuteString(s);
	}
}
