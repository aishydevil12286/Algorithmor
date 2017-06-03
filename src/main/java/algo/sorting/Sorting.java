package algo.sorting;

public class Sorting {
	
	private void swap(Comparable a,Comparable b){
		Comparable swap = a;
		a = b;
		b = swap;		
	}
	
	private boolean isLess(Comparable a,Comparable b){
		return (a.compareTo(b) < 0);
		}
	
	private boolean isEqual(Comparable a,Comparable b){
		return (a.compareTo(b)== 0);
	}
	
	private int getMinIndex(Comparable[] a, int beg,int end){
		int min = beg;
		for(int i=beg+1;i<end;i++){
			if (isLess(a[i],a[min])){
				min = i;
			}
		}
		return min;
	}
	
	public void selectionSort(Comparable[] a){
		int N = a.length;
		for(int i = 0;i<N;i++){
			int min = i;
			for(int j = i+1;j<N;j++){
				if(a[j].compareTo(a[min])<0){
					min = j;
				}
			}
			if(min != i){
			Comparable temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			}
			for(int k =0;k<a.length;k++){
	        	System.out.print(a[k]);
	        	
	        }
			System.out.println("");
		}
	}
	
	public void insertionSort(Comparable[] a){
		int N = a.length;
        for(int i =1;i<N;i++){
        	for(int j=i;j>0;j--){
        		if(a[j].compareTo(a[j-1])<0){
        			Comparable temp = a[j];
        			a[j] = a[j-1];
        			a[j-1] = temp;
        		}
        	}
        }
	}

	public static void main(String[] args) {
		Sorting sorter = new Sorting();
		String[] test = {"S","E","L","E","C","T","I","O","N","S","O","R","T"};
		sorter.insertionSort(test);
        for(int i =0;i<test.length;i++){
        	System.out.print(test[i]);
        }

	}

}
