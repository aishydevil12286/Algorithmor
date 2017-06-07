package algo.dynamic;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/ * 
 */

public class CoinChange_MinimumCoins {
	
	public static int recursiveMinimumCount(int[] coins,int sum ){
		// Base case : Sum <= 0
		// How many ways to get sum <= 0 ? 
		if(sum<=0){
			return 0;
		}
		
		/*Else let's pick one coin of each denomination each
		 * and get the minimum number of coins needed for those cases
		 */
		int result = Integer.MAX_VALUE;
		// Iterate over all denominations and pick each one by one
		for(int i=0;i<coins.length;i++){
			if(coins[i]<=sum){
				// This is equivalent to picking one coin from the list at index i and
				// finding the minimum coins needed for sum-coin[i]
				int temp = recursiveMinimumCount(coins,sum-coins[i]);
				
				// If the sum of temp result obtained from sub problem + 1 (for the picked coin)
				// is less than the current value of result in the loop
				// then replace the result with temp+1
				if(temp != Integer.MAX_VALUE && temp+1 < result){
					result = temp+1;
				}
			}
		}
		// After all recursions and solutions of sub problems we are left with the minimum value
		return result;
	}
	
	private static int[] dp;
	
	public static int dynamicMinimumCount(int[] coins,int sum){
		//initialize dp array
		if(dp==null){
			dp = new int[sum+1];
			dp[0]=0;
			for(int i=1;i<dp.length;i++){
				dp[i]=Integer.MAX_VALUE;
			}
		}
		// Build up the DP table for all sum values from 0,1,....,sum
		for(int i=1;i<=sum;i++){
			// For each sum value try finding the minimum by selecting each denomination once
			for(int j=0;j<coins.length;j++){
				if(coins[j]<=i){
					int temp = dp[i-coins[j]];
					if(temp!=Integer.MAX_VALUE && temp+1<i){
						dp[i]=temp+1;
					}
				}
			}
		}
		return dp[sum];
	}
	
	public static void main(String[] args){
		int[] coins = {1,2,3};
		System.out.println(recursiveMinimumCount(coins,11));
		System.out.println(dynamicMinimumCount(coins,5));
	}
}
