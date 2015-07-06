package ds.trees.bst;

import java.util.StringTokenizer;


public class SerializableBinarySearchTree<K extends Comparable<K>>{
	
	private static final long serialVersionUID = -8047345267967142073L;
	private Node<K> root;
	
	public Node<K> getRoot() {
		return root;
	}

	public void add(K key){
		root = add(root,key);
	}
	
	private Node<K> add(Node<K> node,K key){
		if(node == null){
			return new Node<K>(key);
		}
		int compare = key.compareTo(node.key);
		if(compare < 0){
			// progress in left sub-tree
			node.left = add(node.left,key);
		}else if(compare > 0){
			// progress in right sub-tree
			node.right = add(node.right,key);
		}else{
			// key-match. Overwrite value
			node.key = key;
		}
		return node;
	}
	
	public Node<K> getNode(K key){
		Node<K> n = root;
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
	

	private Node<K> min(Node<K> root){
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
	
	private Node<K> max(Node<K> root){
		if(root.right == null){
			return root;
		}else{
			return max(root);
		}
	}
	
	public boolean isInOrderSame(Node<K> root1, Node<K> root2){
		boolean same = true;
		
		if(root1 == null && root2 == null){
			return same;
		}else if((root1 == null && root2!=null)||(root1!= null && root2 == null)){
			same = false;
			return same;
		}else{
			if(root1.key.equals(root2.key)){
				same &= isInOrderSame(root1.left,root2.left);
				same &= isInOrderSame(root1.right,root2.right);
			}else{
				same = false;
				return same;
			}
		}
		return same; 
	}
	
	public String serialize(){
		StringBuilder sb = new StringBuilder();
		recursiveSerialize(root,sb);
		return sb.toString();
	}
	
	private void recursiveSerialize(Node root,StringBuilder sb){
		if(root == null){
			sb.append("#").append(',');
		}else{
			sb.append(root.key).append(',');
			recursiveSerialize(root.left,sb);
			recursiveSerialize(root.right,sb);
		}
	}
	
	private SerializableBinarySearchTree<K> deserialize(String sTree){
		SerializableBinarySearchTree<K> bst = new SerializableBinarySearchTree<K>();
		
		StringTokenizer st = new StringTokenizer(sTree,",");
		SerializableBinarySearchTree<K>.Node<K> node = recursiveDeserialize(st);
		bst.root = node;
		return bst;
	}
	
	private Node<K> recursiveDeserialize(StringTokenizer st){
		Node<K> returnNode = null;
		if(st.hasMoreTokens()){
			String token = st.nextToken();
			if(!token.equals("#")){
			returnNode = new Node((K)token);
			returnNode.left  = recursiveDeserialize(st);
			returnNode.right = recursiveDeserialize(st);
	        }
		}
		return returnNode;
	}
	
	class Node<T extends Comparable<T>>{
		
		T key;
		
		Node<T> left,right;
		
		public Node(T key){
			this.key = key;
			this.left = null;
			this.right = null;
		}
		
		public Node(T key,Node<T> left, Node<T> right){
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		
		SerializableBinarySearchTree<String> bst1 = new SerializableBinarySearchTree<String>();
		bst1.add("D");
		bst1.add("B");
		bst1.add("F");
		bst1.add("A");
		bst1.add("C");
		bst1.add("E");
        //System.out.println(bst1.isInOrderSame(bst1.getRoot(), bst2.getRoot()));
		String bst1Serialize = bst1.serialize();
		System.out.println(bst1Serialize);
		SerializableBinarySearchTree<String> bst2 = bst1.deserialize(bst1Serialize);
		String bst2Serialize = bst2.serialize();
		System.out.println(bst2Serialize);
	}

}
