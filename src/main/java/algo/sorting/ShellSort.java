package algo.sorting;

public class ShellSort {
	
	public static void shellSort(int[] a){
		int N = a.length;
		int h =1;
		while(h<N/3){
		h = 3*h+1; // increment by 3x+1
		}
		
		while(h>0){
			//h-sort the array
			for(int i =h;i<N;i+=h){
	        	for(int j=i;j>=h&&a[j]<a[j-h];j-=h){
	        			int temp = a[j];
	        			a[j] = a[j-h];
	        			a[j-h] = temp;
	        		}
	        	}
	        	h = h/3;
	        }
		
	}

	public static void main(String[] args) {
		int[] a = {1,3,2,5,3,5,67,4,3};
		shellSort(a);
		for(int i =0;i<a.length;i++)
			System.out.println(a[i]);
	}
		
	}
