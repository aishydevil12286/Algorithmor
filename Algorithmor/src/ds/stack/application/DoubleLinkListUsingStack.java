package ds.stack.application;

import java.util.Stack;
import java.util.LinkedHashMap;


public class DoubleLinkListUsingStack<E> {
	private Stack<E> h = new Stack<E>();
	private Stack<E> t = new Stack<E>();
	private int size = 0;
	
	/*
	 * Returns number of elements in the list
	 */
	public int size(){
		return size;
	}
	
	/*
	 * Inserts the specified element at the beginning of this list.
	 */
	public void addFirst(E element){
		if(h.empty()){
			h.push(element);
		}else{
		while(!h.empty()){
			t.push(h.pop());
		}
		h.push(element);
		}
		size++;
	}
	
	/*
	 * Inserts the specified element at the end of this list.
	 */
	public void addLast(E element){
		if(t.empty()){
			t.push(element);
		}else{
		while(!t.empty()){
			h.push(t.pop());
		}
		t.push(element);
		}
		size++;
	}
	
	/*
	 * Inserts the specified element at the specified index
	 */
	public void add(int index, E element){
		if(index > size){
		   // Can't insert
			System.out.println("Index out of bounds");
		}else{			
			if(h.size() > index){
			while(h.size()>index){
				t.push(h.pop());
			}
			h.push(element);
			size++;
			}else{
			while(h.size()<= index){
				h.push(t.pop());
			}
			h.push(element);
			size++;
			}
		}
	}
	
	/*
	 * Returns the index of the first occurrence of the specified element in this list, 
	 * or -1 if this list does not contain the element.
     */
	public int indexOf(E element){
		while(!h.empty()){
			t.push(h.pop());
		}
		while(t.peek()!= element){
			h.push(t.pop());
		}
		if(t.empty()){
			return -1;
		}else{
			return h.size();
		}
	}
	
	/*
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(E element){
		return indexOf(element) >= 0;
	}
	
	/*
	 * Replaces the element at the specified position in this list with the specified element.
	 */
	public void set(int index,E element){
		if(index > size){
			   // Can't insert
				System.out.println("Index out of bounds");
			}else{			
				if(h.size() > index+1){
				while(h.size() > index){
					t.push(h.pop());
				}
				h.pop();
				h.push(element);
				}else{
				while(h.size()<= index){
					h.push(t.pop());
				}
				t.pop();
				h.push(element);
				}
			}
	}
	
	/*
	 * Removes first occurrence of element in the list
	 */
	public void removeFirst(E element){
		if(size == 0){
			System.out.println("Stack Empty. Nothing to remove");
		}else{
			while(!h.empty()){
				t.push(h.pop());
			}
			while(t.peek() != element){
				h.push(t.pop());
			}
			if(!t.empty()){
				t.pop();
			}
			size--;
		}
	}
	
	
	/*
	 * Removes last occurrence of the element in the list
	 */
	public void removeLast(E element){
		if(size == 0){
			System.out.println("Stack Empty. Nothing to remove");
		}else{
			while(!t.empty()){
				h.push(t.pop());
			}
			while(h.peek() != element){
				t.push(h.pop());
			}
			if(!h.empty()){
				h.pop();
			}
			size--;
		}
	}

	
	/*
	 * Gets the first value in the List
	 */
	public E getFirst(){
		while(h.size() > 1){
			t.push(h.pop());
		}
		return h.peek();
	}
	
	/*
	 * Returns the last value in the list
	 */
	public E getLast(){
		while(t.size() > 1){
			h.push(t.pop());
		}
		return t.peek();
	}
	
	/* 
	 * Returns the value at the specified index
	 */
	public E get(int index){
		E val = null;
		if(index > size-1){
				return null; // index out of bounds
			}else{
				if(h.empty()){
					// pop index number of times from t to h and then peek()
					while(h.size() < index){
						h.push(t.pop());
					}
					val = t.peek();
				}else if(t.empty()){
					// pop from h to t till index comes to top
					while(h.size() > index+1){
						t.push(h.pop());
					}
					val = h.peek();
				}else if(index < h.size()){
					// element is in stack h
					while(h.size() > index+1){
						t.push(h.pop());
					}
					val = h.peek();
				}else{
					// element is in stack t
					while(h.size() < index){
						h.push(t.pop());
					}
					val = t.peek();
				}

			}
		return val;
	}

}
