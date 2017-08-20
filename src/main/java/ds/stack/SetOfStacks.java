package ds.stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class SetOfStacks<V> implements Stack<V>{
	private ArrayList<Integer> sizes;
	private final int threshold;
	private ArrayList<LinkedList<V>> index;
	private int SIZE;
	
	public SetOfStacks(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public V pop() {
		// Start from the last subStack
		int i = index.size()-1;
		while(index.get(i).isEmpty()){
			// Do clean up
			index.remove(i--);
		}
		if(i<0){
			// index became empty
			return null;
		}
		LinkedList<V> stack = null;
		if(SIZE>0){
			stack = index.get(i);
			SIZE--;
		}
		return stack.removeFirst();
	}

	@Override
	public void push(V v) {
		int i = index.size()-1;
		if(index.get(i).size()== threshold){
			// Create a new stack
			LinkedList<V> stack = new LinkedList<>();
			stack.addFirst(v);
			index.add(i+1,stack);
		}else{
			index.get(i).addFirst(v);
		}
		SIZE++;
	}

	@Override
	public V peek() {
		// Start from the last subStack
		int i = index.size()-1;
		while(index.get(i).isEmpty()){
			// Do clean up
			index.remove(i--);
		}
		return index.get(i).getFirst();
	}

	@Override
	public boolean isEmpty() {
		if(index.isEmpty() || (index.size()==1 && index.get(0).isEmpty())){
			return true;
		}
		return false;
	}

	@Override
	public V popAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
