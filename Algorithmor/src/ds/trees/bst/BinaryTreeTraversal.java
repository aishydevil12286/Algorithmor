package ds.trees.bst;

public class BinaryTreeTraversal {
	public Node root;
	
	public static void inOrder(Node root){ // Left -> Root -> Right
		if(root == null){
			return;
		}
		inOrder(root.left);
    	root.printNode();
		inOrder(root.right);
	}
	
	public static void preOrder(Node root){ // Root -> Left -> Right
		if(root == null){
			return;
		}
		root.printNode();
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node root){ // Left -> Right -> Root
		if(root == null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		root.printNode();
	}

	public static void main(String[] args) {
		Node root = new Node('A');
		root.left = new Node(new Node('D'),new Node('E'),'B');
		root.right = new Node(new Node('F'),new Node('G'),'C');
		System.out.println("In Order Traversal");
		inOrder(root);
		System.out.println("\nPre Order Traversal");
		preOrder(root);
		System.out.println("\nPost Order Traversal");
		postOrder(root);
	}

}
