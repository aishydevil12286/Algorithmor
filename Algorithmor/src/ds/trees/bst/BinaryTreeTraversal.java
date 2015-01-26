package ds.trees.bst;

public class BinaryTreeTraversal {
	public Node root;
	
	public void inOrder(Node root){ // Left -> Root -> Right
		if(root == null){
			return;
		}
		inOrder(root.left);
    	root.printNode();
		inOrder(root.right);
	}
	
	public void preOrder(Node root){ // Root -> Left -> Right
		if(root == null){
			return;
		}
		root.printNode();
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(Node root){ // Left -> Right -> Root
		if(root == null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		root.printNode();
	}

	public static void main(String[] args) {
		BinaryTreeTraversal traverse = new BinaryTreeTraversal();
		traverse.root = new Node('A');
		traverse.root.left = new Node(new Node('D'),new Node('E'),'B');
		traverse.root.right = new Node(new Node('F'),new Node('G'),'C');
		System.out.println("In Order Traversal");
		traverse.inOrder(traverse.root);
		System.out.println("\nPre Order Traversal");
		traverse.preOrder(traverse.root);
		System.out.println("\nPost Order Traversal");
		traverse.postOrder(traverse.root);

	}

}
