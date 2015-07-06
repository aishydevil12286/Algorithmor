package rough;

public class Diameter {

	/*
	 * Complete the function below.
	 */

	    static void treeDiameter(int[] values) {
	        
	        Node root= new Node(values[0]);
	        root = add(root,values[0]);
	        for(int i=1;i<values.length;i++){
	            add(root,values[i]);
	        }
	        
	        System.out.println(diameter(root));
	    }

	    public static class Node{
	        public Node left;
	        public Node right;
	        public int value;
	        
	        public Node(int v){
	            this.value = v;
	        }
	    }

	    public static Node add(Node node,int val){
	        if(node==null){
	            return new Node(val);
	        }else if(val<node.value){
	            // add in left sub-tree
	            node.left = add(node.left,val);
	        }else if(val>node.value){
	            // add in right sub-tree
	            node.right = add(node.right,val);
	        }else{
	            //overwrite the value
	        }
	        
	        return node;
	        }
	         
	        
	    public static int height(Node root){
	        if(root==null){
	            return 0;
	        }else{
	            return 1+Math.max(height(root.left),height(root.right));
	        }
	    }
	        
	    public static int diameter(Node root){
	        if(root==null){
	            return 0;
	        }
	        
	        int main = 1+height(root.left)+height(root.right);
	        int ldia = diameter(root.left);
	        int rdia = diameter(root.right);
	        
	        return Math.max(main,Math.max(ldia,rdia));
	    }   
	 
	public static void main(String[] args) {
		int[] arr = {9,5,4,3,2,1,6,7,8,9};
		treeDiameter(arr);

	}

}
