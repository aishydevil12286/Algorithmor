package ds.trees;

/*
 * A generic binary tree that uses nodes with Keys of type T and value of type E
 */
public class BinaryTree<T extends Comparable<T>> {
	private Node<T> root;
	
	/*
	 * returns the height of the binary tree
	 */
	public int height(){
		return height(root);	
	}
	
	/*
	 * returns the height of the subTree rooted at the passed in node
	 */
	private int height(Node<T> node){
		int height = 0;
		if(node==null){
				return height;
			}else{
				height = 1+Math.max(height(node.getLeft()),height(node.getRight()));
			}
		return height;
	}
	
	/*
	 * calculates if the Binary Tree is balanced
	 */
	public boolean isBalanced(){
		return isNBalanced(this.root,1);
	}
	
	public boolean isNBalanced(Node<T> node,int N){
		boolean flag = true;
		if(node!=null){
			if(Math.abs(node.getLeft().size()-node.getRight().size())<=N){
				flag = true;
			}else{
				flag = isNBalanced(node.getLeft(),N)&&isNBalanced(node.getRight(),N);
			}
		}
		return flag;
	}
	
	/*
	 * Returns a boolean flag indicating whether the Tree is symmetric or not
	 */
	public boolean isSymmetric(Node<T> nodeL,Node<T> nodeR){
		boolean flag = false;
		
		if(nodeL!=null&&nodeR!=null){
			if(nodeL.size()==1&&nodeR.size()==1&&nodeL.equals(nodeR)){
				flag = true;
			}else{
				flag = isSymmetric(nodeL.getLeft(),nodeR.getRight())&& isSymmetric(nodeL.getRight(),nodeR.getLeft());
			}
		}		
		return flag;
	}
	
	public int diameter(){
		return diameter(root);
	}
	
	public int diameter(Node<T> root){
		int diameter = 0;
        if(root==null){
            return diameter;
        }
        
        int main = 1+height(root.getLeft())+height(root.getRight());
        int ldia = diameter(root.getLeft());
        int rdia = diameter(root.getRight());
        
        return Math.max(main,Math.max(ldia,rdia));
	}
	
	public void add(T value){
		root = add(root,value);
	}
	//TODO 
	//This should be a general binary tree
	private Node<T> add(Node<T> node,T value){
		if(node == null){
			return new Node<T>(value);
		}
		if(value.compareTo(node.getValue())<0){
			// progress in left sub-tree
			node.setLeft(add(node.getLeft(),value));
		}else if(value.compareTo(node.getValue())>0){
			// progress in right sub-tree
			node.setRight(add(node.getRight(),value));
		}
		// else the value matches
		// so do nothing or overwrite
		// here i do nothing
		return node;
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
	}
}
