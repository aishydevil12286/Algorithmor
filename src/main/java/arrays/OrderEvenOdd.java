package arrays;

/*
 * Input = array of integers
 * Problem = re-order the elements so that the even entries appear first without using extra space
 */

public class OrderEvenOdd {
	
	public static int[] reorder(int[] A){
		if(A.length == 0 || A.length == 1){
			return A;
		}
		
		int Peven = 0;
		int Podd = A.length-1;
		
		while(Peven < Podd){
			if(A[Peven]%2!=0 && A[Podd]%2==0){
				//swap
				int temp = A[Peven];
				A[Peven++] = A[Podd];
				A[Podd--] = temp;
			}
			if(A[Peven]%2==0){
				Peven++;
			}
			if(A[Podd]%2!=0){
				Podd--;
			}
		}
		
		return A;
	}
	
	public static void main(String[] args){
		int[] arr = {1,4,5,2,7,9,5,3,9,13,15,16,12};
		int[] arr2 = reorder(arr);
		for(int i : arr2){
			System.out.print(i+" ");
		}
	}

}
