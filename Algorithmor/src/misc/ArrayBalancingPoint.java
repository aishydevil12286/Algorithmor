package misc;

public class ArrayBalancingPoint {

	public static int balancePoint(int[] array){
		int pos = array.length/2;
		int lsum=0;
		int rsum=0;
		for(int i=0;i<pos;i++){
			lsum +=array[i];
		}
		for(int j=array.length-1;j>pos;j--){
			rsum +=array[j];
		}
		System.out.println("lsum = "+lsum);
		System.out.println("rsum = "+rsum);		
		
		while(lsum!=rsum){
			if(lsum>rsum){
				rsum += array[pos--];
				lsum -= array[pos];
			}else if(lsum<rsum){
				lsum += array[pos++];
				rsum -= array[pos];
			}else{
				return pos;
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		int[] array = {10,1,1,1,1,1,1,1,1,2,1,-2,1,1};
		int x = balancePoint(array);
		System.out.println(x);
	}

}
