package ds.trees.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFS {
	
	public Node root;
	
	public BFSDFS(char c){
		this.root = new Node(c);
	}
		
		public  void bfs(){
			// BFS uses Queue data structure
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this.root); // Add the root to the queue
			this.root.printNode();
			root.visited = true; // Mark the root as visited
			while(!queue.isEmpty()) { // While the queue is not empty
				Node node = (Node)queue.remove();
				Node child=null;
				while((child=getUnvisitedChildNode(node))!=null) {
					child.visited=true;
					child.printNode();
					queue.add(child);
				}
			}
			// Clear visited property of nodes
			//clearNodes();
		}
		
		public void dfs(){
			// DFS uses Stack data structure
			Stack<Node> stack = new Stack<Node>();
			stack.push(this.root);
			root.visited=true;
			root.printNode();
			while(!stack.isEmpty()) {
				Node node = (Node)stack.peek();
				Node child = getUnvisitedChildNode(node);
				if(child != null) {
					child.visited = true;
					child.printNode();
					stack.push(child);
				}
				else {
					stack.pop();
				}
			}
		}
		
		public Node getUnvisitedChildNode(Node node){
			if(node.left != null && !node.left.visited){
				return node.left;
			}else if(node.right != null && !node.right.visited){
				return node.right;
			}else{
				return null;
			}
		}

	public static void main(String[] args) {
		BFSDFS bfsdfs = new BFSDFS('A');
		bfsdfs.root.left = new Node(new Node('D'),new Node('E'),'B');
		bfsdfs.root.right = new Node(new Node('F'),new Node('G'),'C');
		bfsdfs.dfs();

	}

}
