package arrays;

import java.util.Arrays;

public class LongestIncreasingSubarray {

	public static int[] longestIncreasingSubarray(int[] A){
		
		int prevMaxLo = 0;
		int prevMaxHi = 0;
		int currMaxLo = 0;
		int currMaxHi = 0;
		int[] B;
		
		for(int i=1;i<A.length;i++){
			if(A[i-1]<A[i]){
				currMaxHi++;
			}else{
				if((currMaxHi-currMaxLo)>(prevMaxHi-prevMaxLo)){
				prevMaxLo = currMaxLo;
				prevMaxHi = currMaxHi;
				}
				currMaxLo = i;
				currMaxHi = i;
			}
		}
		
		if((currMaxHi-currMaxLo)>(prevMaxHi-prevMaxLo)){
			B = Arrays.copyOfRange(A,currMaxLo,currMaxHi);
		}else{
			B = Arrays.copyOfRange(A,prevMaxLo,prevMaxHi);
		}
		return B;
	}
	public static void main(String[] args){
		int[] A = {1,9,18,7,25,38,46,58,72,52,10};
		int [] longestSubsequence = longestIncreasingSubarray(A);
		System.out.println(Arrays.toString(longestSubsequence));
	}
}
