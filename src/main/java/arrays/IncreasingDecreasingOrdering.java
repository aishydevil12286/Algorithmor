package arrays;

import java.util.Arrays;

public class IncreasingDecreasingOrdering {

	public static void main(String[] args) {
		int[] arr = {7,3,5,6,2,1,9,4,8};
		System.out.println(Arrays.toString(arr));
		rearrange(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void rearrange(int[] arr)
	{ int n = arr.length;
		for (int i = 0; i < n - 1; i++)
		{
			if (i % 2 == 0)
			{
				if (arr[i] > arr[i+1])
					swap(arr,i,i+1);
			}
			else
			{
				if (arr[i+1] > arr[i])
					swap(arr,i,i+1);
			}
		}
	}
	
	private static void swap(int[] arr,int a, int b){
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
