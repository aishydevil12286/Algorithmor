package ds.trees.bst;

import java.util.Stack;

public class BinaryTreeTraversal {
	public SimpleNode root;
	
	public static void inOrder(SimpleNode root){ // Left -> Root -> Right
		if(root == null){
			return;
		}
		inOrder(root.left);
    	root.printNode();
		inOrder(root.right);
	}
	
	public static void preOrder(SimpleNode root){ // Root -> Left -> Right
		if(root == null){
			return;
		}
		root.printNode();
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(SimpleNode root){ // Left -> Right -> Root
		if(root == null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		root.printNode();
	}
	/*
	 * Also known as Spiral traversal.
	 * Switches direction of printing at each level
	 * 
	 *     
	 *  ->->->->->->->->->->->->
	 *                          |
	 *  <-<-<-<-<-<-<-<-<-<-<-<-
	 *  |
	 *  ->->->->->->->->->->->->
	 *                          |
	 *  <-<-<-<-<-<-<-<-<-<-<-<-
	 *  
	 *  1. Create an empty stack s and push root to it.
	 *  2. Create a direction flag and set it to false.
	 *  2. While stack is not NULL Do following
		    2a. Create a empty stack called tempStack.
		    2b. Pop a node from stack and push it to tempStack depending on directionFlag,
		        i.e if it is set then push nodes from right to left
		    2c. Change directionFlag to change the direction of traversal
		    2d. Set stack=tempStack
	 */
	public static void zigzag(SimpleNode root){
		if(root==null) return;   
        Stack<SimpleNode> stack=new Stack<SimpleNode>();  
        stack.push(root);  
          
        boolean directionflag=false;  
        while(!stack.isEmpty())  
        {  
            Stack<SimpleNode> tempStack=new Stack<SimpleNode>();  
          
            while(!stack.isEmpty())  
            {  
                SimpleNode tempNode=stack.pop();  
                tempNode.printNode();  
                if(!directionflag)   
                {  
                    if(tempNode.left!=null)   
                     tempStack.push(tempNode.left);  
                    if(tempNode.right!=null)   
                     tempStack.push(tempNode.right);  
                }else  
                {  
                    if(tempNode.right!=null)   
                     tempStack.push(tempNode.right);  
                    if(tempNode.left!=null)   
                     tempStack.push(tempNode.left);  
                }  
            }  
            // for changing direction  
            directionflag=!directionflag;   
        
            stack=tempStack;   
        }  
	}

	public static void main(String[] args) {
		SimpleNode root = new SimpleNode('A');
		root.left = new SimpleNode(new SimpleNode('D'),new SimpleNode('E'),'B');
		root.right = new SimpleNode(new SimpleNode('F'),new SimpleNode('G'),'C');
		System.out.println(" In Order Traversal");
		inOrder(root);
		System.out.println("\n Pre Order Traversal");
		preOrder(root);
		System.out.println("\n Post Order Traversal");
		postOrder(root);
		System.out.println("\n Zig Zag Order Traversal");
		zigzag(root);
	}

}
