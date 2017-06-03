package algo.sorting;

public class InsertionSort {

	public static void insertionSort(int[] a){
		int N = a.length;
        for(int i =1;i<N;i++){
        	for(int j=i;j>0;j--){
        		if(a[j]<a[j-1]){
        			int temp = a[j];
        			a[j] = a[j-1];
        			a[j-1] = temp;
        		}
        	}
        }
	}

	public static void main(String[] args) {
		int[] a = {1,3,2,5,3,5,67,4,3};
		insertionSort(a);
		for(int i =0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
