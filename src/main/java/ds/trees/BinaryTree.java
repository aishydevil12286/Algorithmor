package ds.trees;

import java.util.ArrayList;
import java.util.List;

/*
 * A generic binary tree that uses nodes with Keys of type T and value of type E
 */
public class BinaryTree<T extends Comparable<T>> {
	private Node root;
	
	/*
	 * returns the height of the binary tree
	 */
	public int height(){
		return height(root);	
	}
	
	/*
	 * returns the height of the subTree rooted at the passed in node
	 */
	private int height(Node node){
		int height = 0;
		if(node==null){
				return height;
			}else{
				height += 1+Math.max(height(node.left),height(node.right));
			}
		return height;
	}
	
	/*
	 * calculates if the Binary Tree is balanced
	 */
	public boolean isBalanced(){
		return isNBalanced(this.root,1);
	}
	
	public boolean isNBalanced(Node node,int N){
		boolean flag = true;
		if(node!=null){
			if(Math.abs(node.left.size-node.right.size)<=N){
				flag = true;
			}else{
				flag = isNBalanced(node.left,N)&&isNBalanced(node.right,N);
			}
		}
		return flag;
	}
	
	/*
	 * Returns a boolean flag indicating whether the Tree is symmetric or not
	 */
	public boolean isSymmetric(Node nodeL,Node nodeR){
		boolean flag = false;
		
		if(nodeL!=null&&nodeR!=null){
			if(nodeL.size==1&&nodeR.size==1&&nodeL.equals(nodeR)){
				flag = true;
			}else{
				flag = isSymmetric(nodeL.left,nodeR.right)&& isSymmetric(nodeL.right,nodeR.left);
			}
		}		
		return flag;
	}
	
	public int diameter(){
		return diameter(root);
	}
	
	public int diameter(Node root){
		int diameter = 0;
        if(root==null){
            return diameter;
        }
        
        int main = 1+height(root.left)+height(root.right);
        int ldia = diameter(root.left);
        int rdia = diameter(root.right);
        
        return Math.max(main,Math.max(ldia,rdia));
	}
	
	public void add(T value){
		root = add(root,value);
	}
	
	//Addition follows for a general balanced binary tree
	public Node add(Node root,T value){
		
		if(root == null){
			return new Node(value);
		}
		
		if(root.left == null){
			root.left = add(root.left,value);
		}else if(root.right==null){
			root.right = add(root.right,value);
		}else if(root.left.size <= root.right.size){
			root.left = add(root.left,value);
		}else{
			root.right = add(root.right,value);
		}
		root.size = 1 + (root.left==null?0:root.left.size)+ (root.right==null?0:root.right.size);
		return root;
	}
	
	// provides sum of a sub-tree rooted at "root"
	private int sum(Node root){
	    int sum = 0;
	    int leftSum = 0;
	    int rightSum = 0;
	    if(root==null){
	        sum = 0;
	        return sum;
	    }
	    
	    if(root.left != null){
	        leftSum = sum(root.left);
	    }
	    
	    if(root.right != null){
	        rightSum = sum(root.right);
	    }
	    
	    sum = leftSum + rightSum + (Integer)root.value;
	    return sum;
	}


	public Node maxSumInTree(Node root){

	Node leftMax = null;
	Node rightMax = null;
	Node max = root;

	if(root == null){
	    return null;
	}

	if(root.left!=null){
	   leftMax = maxSumInTree(root.left);
	}

	if (root.right!=null){
	   rightMax = maxSumInTree(root.right);
	}

	int leftMaxSum = sum(leftMax);
	int rightMaxSum = sum(rightMax);
	int rootSum = sum(root);

	if(rootSum > leftMaxSum && rootSum > rightMaxSum){
	   max = root;
	}
	else{
	   if(leftMaxSum > rightMaxSum){
	    max = leftMax;
	   }else{
	    max = rightMax;
	   }
	}
	return max;
	}
	
	public boolean isPathWithSum(int N){
		return isPathWithSum(root,N);
	}
	
	private boolean isPathWithSum(Node root,int N){
		boolean flag = false;
	//unsafe cast from a generic type to integer. Should be only executed if tree is containing integers.
		if(root == null){
			return false;
		}
		int subSum = N - (Integer)root.value;
		if(root.left == null && root.right == null){
		if(subSum == 0){
			flag = true;
		}
		}else{
		flag = isPathWithSum(root.left,subSum)||isPathWithSum(root.right,subSum);
		}
		return flag;
	}
	
	class Node{
		
		T value;
		int size;
		
		Node left;
		Node right;
		
		public Node(T value){
			this.value = value;
			this.left = null;
			this.right = null;
			this.size = 1;
		}
	}

	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt.add(1);
		bt.add(2);
		bt.add(3);
		bt.add(4);
		bt.add(5);
		bt.add(6);
		bt.add(7);
		bt.add(8);
		//BinaryTree.Node max = bt.maxSumInTree(bt.root);
		System.out.println(bt.isPathWithSum(28));
	}
}
