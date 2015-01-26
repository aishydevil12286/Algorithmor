package misc;

import java.util.Stack;

public class MergeTwoSortedArays {

	public static void main(String[] args) {
		Integer[] a = {1,2,2,3,4,5,11,15};
		Integer[] b = new Integer[18];
		for(int p=0;p<10;p++){
			b[p]=p+10;
		}

		int i = a.length-1;
		int j = b.length-1;
		while(b[j]== null)
			j--; // Get the pointer to the last not null value
		int k = i+j+1;
		
		while(k>0){
			if(i<0 ){
				break; // break if first array values are exhausted 
			}
			if(j<0){
				//Copy values from 1st array in order if the 2nd array values are exhausted
				while(i>=0){
					b[k--] = a[i--];
				}
				break;
			}
			
			int cmp = a[i].compareTo(b[j]);
			if(cmp < 0){
				b[k--] = b[j--];
			}
			else if (cmp > 0){
				b[k--] = a[i--];
			}
			else{
				b[k--] = a[i--];
				b[k--] = b[j--];
			}
		}
		for(int m=0;m<b.length;m++){
			System.out.print(b[m]+" ");
		}
	}

}
