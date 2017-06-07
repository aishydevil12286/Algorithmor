package algo.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	private int[] temp;
	private int[] arr;
	private int[] prev;
	private int max = 0;
	private int maxIndex = -1;
	
	public void calculateLIS(int[] arr){
		this.arr = arr;
		this.temp = new int[arr.length];
		this.prev = new int[arr.length];
		// Each element in itself is a subsequence
		// So, initialize each index value as 1
		Arrays.fill(temp,1);
		Arrays.fill(prev,-1);
		
		for(int i=1;i<arr.length;i++){
			for(int j=i-1;j>=0;j--){
				if(arr[j]<arr[i]){
					temp[i]=Math.max(temp[j]+1, temp[i]);
					if(temp[i]>max){
						max = temp[i];
						maxIndex = i;
					}
					// Keep track of previous elements in the sequence
					if(temp[i]-temp[j]==1){
						prev[i]=j;
					}
				}
			}
		}
	}
	
	public int getLength(){
		return max;
	}
	
	public int[] getSequence(){
		int[] sequence = new int[max];
		int p = max-1;
		int index = maxIndex;
		sequence[p--] = arr[index];
		while(prev[index]!=-1 && p>=0){
			sequence[p--] = arr[prev[index]];
			index = prev[index];
		}		
		return sequence;
	}
	
	public static void main(String[] args){
		int[] arr = {3,4,-1,0,6,2,3,5,7,8,-5,4,6,8};
		LongestIncreasingSubsequence calculator = new LongestIncreasingSubsequence();
		calculator.calculateLIS(arr);
		System.out.println(calculator.getLength());
		int[] sequence = calculator.getSequence();
		for(int i : sequence){
			System.out.println(i);
		}
	}

}
