package ds.heap;

public interface Heap<T extends Comparable<T>>{
	
	public void insert(T t);
	
	public void sort();
	
	public void reverseSort();
	
	public void printHeap();	
	
	public static enum HeapType{MIN,MAX};

}
