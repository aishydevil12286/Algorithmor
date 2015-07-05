package ds.trees.bst;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class BinarySearchTree<K extends Comparable<K>,V> {
	
	protected Node<K,V> root;
	
	public Node<K, V> getRoot() {
		return root;
	}

	public void add(K key,V value){
		root = add(root,key,value);
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node<K,V> node){
		return node.size;
	}
	
	private Node<K,V> add(Node<K,V> node,K key,V value){
		if(node == null){
			return new Node<K,V>(key,value,1);
		}
		int compare = key.compareTo(node.key);
		if(compare < 0){
			// progress in left sub-tree
			node.left = add(node.left,key,value);
		}else if(compare > 0){
			// progress in right sub-tree
			node.right = add(node.right,key,value);
		}else{
			// key-match. Overwrite value
			node.value = value;
			node.size = 1 + size(node.left) + size(node.right);
		}
		return node;
	}
	
	public Node<K,V> getNode(K key){
		Node<K,V> n = root;
		while(n != null){
			int compare = key.compareTo(n.key);
			if(compare < 0){
				// progress in left sub-tree
				n = n.left;
			}else if(compare > 0){
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
	
	
	public K min(){
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
	
	public K max(){
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
	
	public boolean isInOrderSame(Node<K,V> root1, Node<K,V> root2){
		boolean same = true;
		
		if(root1 == null && root2 == null){
			return same;
		}else if((root1 == null && root2!=null)||(root1!= null && root2 == null)){
			same = false;
			return same;
		}else{
			if(root1.value.equals(root2.value)){
				same &= isInOrderSame(root1.left,root2.left);
				same &= isInOrderSame(root1.right,root2.right);
			}else{
				same = false;
				return same;
			}
		}
		return same; 
	}
	
	protected class Node<T extends Comparable<T>,N>{
		
		T key;
		N value;
		int size;
		
		Node<T,N> left,right;
		
		public Node(T key,N value, int size){
			this.key = key;
			this.value = value;
			this.size = size;
			this.left = null;
			this.right = null;
		}
		
		public Node(T key,N value,Node<T,N> left, Node<T,N> right,int size){
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.size = size;
		}

	}
	
	public static void main(String[] args) {
		
		BinarySearchTree<String,String> bst1 = new BinarySearchTree<String, String>();
		BinarySearchTree<String,String> bst2 = new BinarySearchTree<String, String>();
		bst1.add("A", "A");
		bst1.add("B", "B");
		bst1.add("C", "C");
		bst2.add("D", "D");
		bst2.add("B", "B");
		bst2.add("C", "C");
        System.out.println(bst1.isInOrderSame(bst1.getRoot(), bst2.getRoot()));
	}

}
