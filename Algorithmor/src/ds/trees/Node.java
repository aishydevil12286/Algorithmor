package ds.trees;

/*
 * K is listed to extend Comparable, because in some cases the nodes will be 
 * needed to be comparable. In case there are no duplicates allowed then the
 * key should be a derived representation of V, which is comparable
 */
public class Node<V extends Comparable<V>>{

	private Node<V> left;
	private Node<V> right;
	private V value;
	private int size;
    
	public Node(V value){
		this.value = value;
		this.size = 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object node){
		boolean flag = false;
		if(node instanceof Node<?>){
			flag = this.value.compareTo(((Node<V>)node).getValue())==0;
		}		
		return flag;		
	}
	
	public Node<V> getLeft() {
		return left;
	}
	public void setLeft(Node<V> left) {
		this.left = left;
	}
	public Node<V> getRight() {
		return right;
	}
	public void setRight(Node<V> right) {
		this.right = right;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public int size() {
		return size;
	}
	
	public void incrementSize(){
		size++;
	}

}
