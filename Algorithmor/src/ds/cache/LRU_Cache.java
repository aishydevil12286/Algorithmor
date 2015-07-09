package ds.cache;

import java.util.Calendar;
import java.util.HashMap;

/*
 * 
 * Note : K should either have a default efficient hashcode method or 
 * one should be implemented to enable this object to be used in HashMap
 * 
 * In this case I am going to use a String data type for testing as it 
 * already has a well-defined hashCode method
 * 
 */
public class LRU_Cache<K,T> implements Cache<K,T>{
	private Calendar calendar = Calendar.getInstance();
	private HashMap<K,CacheNode> map = null;
	private CacheNode head = null; // most recently used
	private CacheNode tail = null; // least recently used
	private int maxSize;
	private int size = 0;
	
	/*
	 * Instantiates a cache object based on the parameter values
	 * 
	 * size     = maximum size of the cache
	 * initSize = initial size of the cache
	 * type     = {LRU,MRU,LFU,MFU}
	 * 
	 */
	public LRU_Cache(int maxSize,int initSize){
		this.maxSize = maxSize;
		if(initSize <= maxSize){
			map = new HashMap<K,CacheNode>(initSize);
		}else{
			map = new HashMap<K,CacheNode>();
		}
	}
	
	public void add(K key,T data){
		if(!map.containsKey(data)){
		   CacheNode node = addToList(data);
		   map.put(key,node);
		}else{
		   map.get(data).incrementFrequency();
		}
	}
	
    public void print(){
    	CacheNode temp = head;
    	while(temp!=null){
    		System.out.println(temp.data.toString());
    		temp = temp.next;
    	}
    }
	
	private CacheNode addToList(T data){
		CacheNode node = new CacheNode(data);
		if(head == null){
			head = node;
			tail = head;
			size++;
		}else{			
			  if(!isFull()){
				   placeInList(node);
			    }
			  else{
				  //System.out.println("Trying to add "+data.toString()+" but the cache size is "+size);
				  makeSpace();
				  placeInList(node);
			      }
		}
		return node;
	}
	
	private void makeSpace(){
		CacheNode temp = tail;
		tail= temp.prev;
		temp.prev = null;
		tail.next = null;
		//System.out.println("Removed LRU node with data = "+temp.data);
		//System.out.println("tails is now at "+tail.data);
		//remove value from the map
		map.remove(temp.data);
		size--;
	}
	
	private void placeInList(CacheNode node){
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}
	
	public boolean isFull(){
		return !(size<maxSize); 
	}
	
	public boolean isEmpty(){
		return !(size>0);
	}
	
	class CacheNode{
		private long timestamp;
		private int frequency;
		private final T data;
		
		public CacheNode next;
		public CacheNode prev;
		
		public CacheNode(T data){
			this.data = data;
			this.frequency = 1;
			this.timestamp = calendar.getTime().getTime();
			this.next = null;
			this.prev = null;
		}
		
		public long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		public int getFrequency() {
			return frequency;
		}
		public void incrementFrequency() {
			this.frequency++;
		}		
		public void decrementFrequency() {
			this.frequency--;
		}
		public T getData() {
			return data;
	    }
    }
	
	public static void main(String[] args){
		LRU_Cache<String,String> stringCache = new LRU_Cache<String,String>(6,3);
		stringCache.add("A","A");
		//stringCache.print();
		//System.out.println("Size of cache is "+stringCache.size);
		stringCache.add("B","B");
		stringCache.add("C","C");
		stringCache.add("D","D");
		stringCache.add("E","E");
		stringCache.add("F","F");
		//stringCache.print();
		//System.out.println("Size of cache is "+stringCache.size);
		stringCache.add("G","G");
		//stringCache.print();
		//System.out.println("Size of cache is "+stringCache.size);
		stringCache.add("H","H");
		stringCache.print();
		System.out.println("Size of cache is "+stringCache.size);
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(K key) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
