package ds.trees.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFS {
	
	private SimpleNode root;
	
	public BFSDFS(char c){
		this.root = new SimpleNode(c);
	}
	/*
	 * The algorithm for Breadth First search in a Binary tree is:
	 * 
	 * 1. Create an empty queue and enqueue the root node.
	 * 2. Print the root node and set it "visited"
	 * 3. While the queue is not empty do :
	 *    3a. Remove a node from queue and see if it has unvisited child nodes.
	 *    3b. While unvisited child nodes are there do : 
	 *        3b1. Iterate over child nodes from left -> right 
	 *        3b2. Print a child, mark it visited and add to the queue.
	 */
		public  void bfs(){
			// BFS uses Queue data structure
			Queue<SimpleNode> queue = new LinkedList<SimpleNode>();
			queue.add(this.root); // Add the root to the queue
			this.root.printNode();
			root.visited = true; // Mark the root as visited
			while(!queue.isEmpty()) { // While the queue is not empty
				SimpleNode simpleNode = (SimpleNode)queue.remove();
				SimpleNode child=null;
				while((child=getUnvisitedChildNode(simpleNode))!=null) {
					child.visited=true;
					child.printNode();
					queue.add(child);
				}
				simpleNode.visited = false; // Clear the visited property for another search
			}
		}

		
		/*
		 * The algorithm for Breadth First search in a Binary tree is:
		 * 
		 * 1. Create an empty stack and push the root node.
		 * 2. Print the root node and set it "visited"
		 * 3. While the stack is not empty do :
		 *    3a. Check if the stack's top node has unvisited child nodes.
		 *    3b. If yes then do : 
		 *        3b1. Iterate over unvisited child nodes from left -> right 
		 *        3b2. Print a child, mark it visited and push to the stack
		 *    3c. Else pop the top node.
		 */
		public void dfs(){
			// DFS uses Stack data structure
			Stack<SimpleNode> stack = new Stack<SimpleNode>();
			stack.push(this.root);
			root.visited=true;
			root.printNode();
			while(!stack.isEmpty()) {
				SimpleNode simpleNode = (SimpleNode)stack.peek();
				SimpleNode child = getUnvisitedChildNode(simpleNode);
				if(child != null) {
					child.visited = true;
					child.printNode();
					stack.push(child);
				}
				else {
					SimpleNode temp = stack.pop(); 
					temp.visited = false;// Clear the visited property
					temp = null;
				}
			}
		}
		
		public SimpleNode getUnvisitedChildNode(SimpleNode simpleNode){
			if(simpleNode.left != null && !simpleNode.left.visited){
				return simpleNode.left;
			}else if(simpleNode.right != null && !simpleNode.right.visited){
				return simpleNode.right;
			}else{
				return null;
			}
		}

	public static void main(String[] args) {
		BFSDFS bfsdfs = new BFSDFS('A');
		bfsdfs.root.left = new SimpleNode(new SimpleNode('D'),new SimpleNode('E'),'B');
		bfsdfs.root.right = new SimpleNode(new SimpleNode('F'),new SimpleNode('G'),'C');
		//System.out.println(" Depth first search");
		//bfsdfs.dfs();
		System.out.println("\n Breadth first search");
		bfsdfs.bfs();

	}

}
