package ds.linkedList;

public class MySingleLinkedList<T> {
	
	Node head;
	//Node tail;
	
	MySingleLinkedList(T[] values){
		for(T t : values){
			add(t);
		}
	}
	
	public void add(T value){
		if(head == null){
			head = new Node(value);
		}else{
			Node node = new Node(value);
			Node temp = head;
			while(temp.next != null){
				  temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public void printList(Node node){
		if(node==null){
		   System.out.print("NULL");
		}else if(node != null){
		   System.out.print(node.value+" --> ");
           printList(node.next);            
		}
	}
	
	public void printList(){
		printList(head);
	}
	
	public Node reverseRecursive(Node prev,Node curr){
		Node temp = null;
		if(curr == null){
		   head = prev;
		}else{
		temp = curr.next;
		curr.next = prev;
		reverseRecursive(curr,temp);
		}
		return head;
	}
	
	public Node reverseRecursive(){
		if(head == null || head.next == null){
			return head;
		}else{
			return reverseRecursive(null,head);
		}
	}
	
	public Node reverseIterative(){
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		if(curr == null){
		   // do nothing
		}else{
			while(curr !=null){
              next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
		   }
		}
		head = prev;
		return prev;
	}
	
	class Node{
		T value;
		Node next;
		
		public Node(T value){
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Integer[] values = {1,2,3,4,5,6,7,8,9,10};
		MySingleLinkedList<Integer> list = new MySingleLinkedList<Integer>(values);
		list.printList();
		//list.reverseRecursive();
		list.reverseIterative();
		System.out.println("");
		list.printList();
	}

}
