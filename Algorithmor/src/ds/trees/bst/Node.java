package ds.trees.bst;

class Node{
	public Node left;
	public Node right;
	public char value;
	public boolean visited = false;
	
	public Node(Node l,Node r,char s){
		this.left = l;
		this.right = r;
		this.value = s;
	}
	
	public Node(char s){
		this.left = null;
		this.right = null;
		this.value = s;
	}
	
	public void printNode(){
		System.out.print(" "+value);
	}
}
