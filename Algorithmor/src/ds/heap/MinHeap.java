package ds.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class MinHeap<T extends Comparable<T>> implements Heap<T> {
	
	private ArrayList<T> heapList;
	HeapType heapType;
	
	public MinHeap(ArrayList<T> list,HeapType heapType){
		if(list.isEmpty()){
			new MinHeap<T>();
		}else{
		this.heapList = list;
		this.heapType = heapType;
		this.heapify();
	    }
	}
	
	public MinHeap(){
	    heapList = new ArrayList<T>();
		heapType = HeapType.MIN;
	}
		
	private void sink(int k, int N) {
		// while the child indexes are less than the Max heap size
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j+1,j)) j++; // to find out which chlid is smaller
            if (!less(j,k)) break;
            exchange(k, j); // exchange the parent child to fix invariant
            k = j; // reassign value to k to continue sinking the invariant-violating element
        }
    }
	
	private boolean less(int i, int j) {
        return heapList.get(i-1).compareTo(heapList.get(j-1)) < 0;
    }
	
	
	private boolean less(T v, T w){
        return (v.compareTo(w) < 0);
    }
	
	private void exchange(int i, int j) {		
        T swap = heapList.get(i-1);
        heapList.set(i-1,heapList.get(j-1));
        heapList.set(j-1,swap);
    }
	
	private boolean isSorted(){
        int N = heapList.size();
		for (int i = 1; i < N; i++)
            if (less(heapList.get(i),heapList.get(i-1))) return false;
        return true;
    }

	@Override
	public void insert(T t){
		heapList.add(t);
		swim(heapList.size());
	}

	private void heapify(){
		int N = heapList.size();
		for (int k = N/2; k >= 1; k--)
            sink(k, N);		
	}

	private void swim(int k) {
		while(k>1 && less(k,k/2)){
			exchange(k,k/2);
			k=k/2;
		}		
	}

	// A MinHeap sorts elements in descending order
	public void sort() {
		if(!isSorted()){
			heapify();
		}
		int N = heapList.size();				
			while (N > 1) {
	            exchange(1, N--);
	            sink(1, N);
	        }		
	}
	
	// Gives the sorted elements in ascending order
	public void reverseSort(){
		sort();
		Collections.reverse(heapList);
	}
	

	public void printHeap(){
		Iterator<T> iter = heapList.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		System.out.println("");
        System.out.println("-------------------------");
	}
	
	public Heap<T> makeMinHeap(ArrayList<T> list){
		Heap<T> buildHeap = new MinHeap<T>(list,HeapType.MIN);
		return buildHeap;		
	}

    // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        String[] b = {"S","O","R","T","E","X","A","M","P","L","E"};
        int size = b.length;
        for(int i=0;i<size;i++){
        	a.add(b[i]);
        }
        MinHeap<String> minHeap = new MinHeap<String>(a,Heap.HeapType.MIN);
        minHeap.printHeap();
        minHeap.insert("A");
        minHeap.insert("D");
        minHeap.insert("Z");
        minHeap.sort();
        minHeap.printHeap();
        minHeap.reverseSort();
        minHeap.printHeap();
    }

}
