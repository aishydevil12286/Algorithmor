package algo.backtracking;

/*
 * http://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
 */

public class MaxNumberInKSwaps {
	// Global max value printed after calculation
	public static String max = "0";
	
	public static void findMax(char[] s,int k){
		if(k==0){
			// No more swaps allowed
			return;
		}
		
		for(int i=0;i<s.length-1;i++){
			for(int j=i+1;j<s.length;j++){
				if(s[i]<s[j]){
					swap(s,i,j);
					String curr = new String(s);
					String temp = max;
					
					if(curr.compareTo(max)>0){
						max = curr;
					}
					
					findMax(s,k-1);
					
					// reset the value for backtracking
					swap(s,i,j);
				}
			}
		}
	}
	
	public static void swap(char[] cs, int x, int y){
		char c = cs[x];
		cs[x]  = cs[y];
		cs[y]  = c;
		
	}

	public static void main(String[] args) {
		String s = "129814999";
		int k = 4;
		findMax(s.toCharArray(),k);
		System.out.println(max);
	}

}
