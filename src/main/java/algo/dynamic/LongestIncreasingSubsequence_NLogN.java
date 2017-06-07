package algo.dynamic;

public class LongestIncreasingSubsequence_NLogN {
	private int[] table;
	private int[] arr;
	private int subLength;
	private int size;
	
	private int findCeilingIndex(int a){
		int l = 0;
		int r = subLength-1;
		while(r-l>1){
			int m = l + (r-l)/2;
			if(arr[m]>=a){
				r = m;
			}else{
				l = m;
			}
		}
		return r;
	}
	
	public void calculate(int[] arr){
		this.arr = arr;
		table = new int[arr.length];
		table[0] = arr[0];
		subLength = 1;
		size = arr.length;
		for(int i=1;i<size;i++){
			
			if(arr[i]<table[0]){
				table[0] = arr[i];
			}
			else if(arr[i]>table[subLength-1]){
				table[subLength++] = arr[i];
			}
			else{
				table[findCeilingIndex(arr[i])] = arr[i];
			}
		}
	}
	
	public int length(){
		return subLength;
	}
	
	public static void main(String[] args){
		int[] arr = {3,4,-1,0,6,2,3,5,7,8,-5,4,6,8};
		LongestIncreasingSubsequence_NLogN calculator = new LongestIncreasingSubsequence_NLogN();
		calculator.calculate(arr);
		System.out.println(calculator.length());
/*		int[] sequence = calculator.getSequence();
		for(int i : sequence){
			System.out.println(i);
		}*/
	}
}
