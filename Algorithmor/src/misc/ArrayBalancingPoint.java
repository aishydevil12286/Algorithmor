package misc;

public class ArrayBalancingPoint {

	public static int balancePoint(int[] array){
		int N = array.length;
		int lsum=0;
		int rsum=0;
		int sum =0;
		int minDiff =0;
		int index = 0;
		for(int i=0;i<N;i++){
			sum +=array[i];
		}
		for(int j=0;j<N;j++){
			lsum = array[j];
			rsum = sum - array[j];
			int diff = Math.abs(lsum-rsum);
			if(diff < minDiff){
				minDiff = diff;
				index = j+1;
			}
		}	
		return index;
	}
	
	public static void main(String[] args) {
		int[] array = {10,-1,-1,-1,1,1,1,1,1,2,1,-2,1,1};
		int x = balancePoint(array);
		System.out.println(x);
	}

}
