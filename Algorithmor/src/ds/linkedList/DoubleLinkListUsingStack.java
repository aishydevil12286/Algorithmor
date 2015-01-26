package ds.linkedList;

import java.util.Stack;

public class DoubleLinkListUsingStack<T> {
	Stack<T> h = new Stack<T>();
	Stack<T> t = new Stack<T>();
	int size = 0;
	
	
	public void insert(T val){
		if(h.empty()){
			h.push(val);
		}else{
		while(!h.empty()){
			t.push(h.pop());
		}
		h.push(val);
		size++;
		}
	}
	
	public void append(T val){
		if(t.empty()){
			t.push(val);
		}else{
		while(!t.empty()){
			h.push(t.pop());
		}
		t.push(val);
		size++;
		}
	}
	
	public void add(int index, T val){
		while(h.size()>index){
			t.push(h.pop());
		}
		h.push(val);
	}

	public static void main(String[] args) {

	
		
	}

}
