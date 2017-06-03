package algo.sorting;

public class MergeSort {
	
	public static void merge(int[] a,int[] aux, int lo,int mid,int hi){
		int i =lo,j=mid+1;
		
		for(int k = lo;k<=hi;k++){
			aux[k] = a[k];
		}
		
		for(int k=lo;k<=hi;k++){
			if(i>mid)				a[k]=aux[j++];
			else if(j>hi)			a[k]=aux[i++];
			else if(aux[j]<aux[i]) 	a[k]=aux[j++];
			else 					a[k]=aux[i++];
		}
		
	}
	
	public static void sort(int[] a){
		int[] aux = new int[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	public static void sort(int[] a,int[] aux,int lo,int hi){
		if(hi<=lo)
			return;
		int mid = lo+(hi-lo)/2; 
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
		
	}

	public static void main(String[] args) {
		int[] a = {1,3,2,5,3,5,67,4,3};
		sort(a);
		for(int i =0;i<a.length;i++)
			System.out.println(a[i]);

	}

}
