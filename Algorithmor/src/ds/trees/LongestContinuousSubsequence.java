package ds.trees;

import java.util.ArrayList;
import java.util.List;

  class TNode{
	int val;
	List<TNode> children = new ArrayList<TNode>();
	
	public TNode(int val){
		this.val = val;
	}
	public void addChild(int val){
		children.add(new TNode(val));
	}
	public TNode getChild(int index){
		return children.get(index);
	}
}

public class LongestContinuousSubsequence {
	
	public static int getLongest(TNode root,List<TNode> longestSoFar,List<TNode> currentSequence){
		if(root == null){
			return 0;
		}
		
		for(TNode child : root.children){
			//Check if the child not 1 greater than the root. Start new sequence
			if(child.val != 1 + root.val){
				currentSequence = new ArrayList();	
			}	
			currentSequence.add(child);

			//Check if the length of sequence ending at this node is greater than the 
			// largest sequence found so far. If yes, we have a new longest. 
			if(currentSequence.size() > longestSoFar.size()){
				longestSoFar = currentSequence;
			}		
	                 getLongest(child, longestSoFar, currentSequence);
		}
		//remove current node from sequence before returning up the stack
		//currentSequence.remove(currentSequence.get(currentSequence.size()));
		return longestSoFar.size();
	}
	
	public static void main(String[] args){
		TNode root = new TNode(1);
		root.addChild(2);
		root.addChild(3);
		root.addChild(2);
		root.getChild(0).addChild(4); // add children to first child of root
		root.getChild(0).addChild(5);
		root.getChild(0).addChild(3);
		List<TNode> longest = new ArrayList<TNode>();
		List<TNode> current = new ArrayList<TNode>();
		System.out.println(getLongest(root,longest,current));
	}

}
