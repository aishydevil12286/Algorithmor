package ds.stack;

public interface Stack<V> {
	
	void push(V v);
	
	V pop();
	
	V peek();
	
	boolean isEmpty();
	
	V popAt(int index);

}
