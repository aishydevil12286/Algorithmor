package ds.trees.bst;

public class BinarySearchTree<K extends Comparable<K>,V> {
	
	protected Node<K,V> root;
	
	public void add(Key<K> key,V value){
		root = add(root,key,value);
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node<K,V> node){
		return node.size;
	}
	
	private Node<K,V> add(Node<K,V> node,Key<K> key,V value){
		if(node == null){
			return new Node<K,V>(key,value,1);
		}
		Key.Comparison compare = key.compareTo(node.key);
		if(compare == Key.Comparison.LESS){
			// progress in left sub-tree
			node.left = add(node.left,key,value);
		}else if(compare == Key.Comparison.GREATER){
			// progress in right sub-tree
			node.right = add(node.right,key,value);
		}else{
			// key-match. Overwrite value
			node.value = value;
			node.size = 1 + size(node.left) + size(node.right);
		}
		return node;
	}
	
	public Node<K,V> getNode(Key<K> key){
		Node<K,V> n = root;
		while(n != null){
			Key.Comparison compare = key.compareTo(n.key);
			if(compare == Key.Comparison.LESS){
				// progress in left sub-tree
				n = n.left;
			}else if(compare == Key.Comparison.GREATER){
				// progress in right sub-tree
				n = n.right;
			}else{
				// key-match. return node
				return n;
			}
		}
		// the node is not found in tree with this key
		return null;
	}
	
	
	public Key<K> min(){
		if(root.left == null){
			return root.key;
		}else{
			return min(root.left).key;
		}
	}
	

	private Node<K,V> min(Node<K,V> root){
		if(root.left == null){
			return root;
		}else{
			return min(root);
		}
	}
	
	public Key<K> max(){
		if(root.right == null){
			return root.key;
		}else{
			return max(root.right).key;
		}
	}
	
	private Node<K,V> max(Node<K,V> root){
		if(root.right == null){
			return root;
		}else{
			return max(root);
		}
	}
	
	public void delete(Key<K> key){
		//TODO
	}
	
	protected class Node<T extends Comparable<T>,N>{
		
		Key<T> key;
		N value;
		int size;
		
		Node<T,N> left,right;
		
		public Node(Key<T> key,N value, int size){
			this.key = key;
			this.value = value;
			this.size = size;
			this.left = null;
			this.right = null;
		}
		
		public Node(Key<T> key,N value,Node<T,N> left, Node<T,N> right,int size){
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.size = size;
		}

	}

}
