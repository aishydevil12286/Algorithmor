package algo.sorting;

public class SelectionSort {
	
	public static void selectionSort(int[] a){
		int N = a.length;
		for(int i=0;i<N;i++){
			int min = i;
			for(int j = i+1;j<N;j++){
				if(a[j]<a[min])
					min = j;
			//System.out.println("i = "+i+" min = "+min);
			}
			if(min != i){
			a[i] = a[i]+ a[min]; // a=a+b
			a[min] = a[i] - a[min]; //b = a-b
			a[i] = a[i] - a[min];// a = a-b
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {1,3,2,5,3,5,67,4,3};
		selectionSort(a);
		for(int i =0;i<a.length;i++)
			System.out.println(a[i]);
	}

}
