package ds.trees.bst;

class SimpleNode{
	public SimpleNode left;
	public SimpleNode right;
	public char value;
	public boolean visited = false;
	
	public SimpleNode(SimpleNode l,SimpleNode r,char s){
		this.left = l;
		this.right = r;
		this.value = s;
	}
	
	public SimpleNode(char s){
		this.left = null;
		this.right = null;
		this.value = s;
	}
	
	public void printNode(){
		System.out.print(" "+value);
	}
}
