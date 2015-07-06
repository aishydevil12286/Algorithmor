package ds.cache;

import java.util.Calendar;
import java.util.HashMap;

/*
 * A cache that can store data of type T and can have various 
 * evacuation strategies based on the type of cache initialized.
 * 
 * Note : K should either have a default efficient hashcode method or 
 * one should be implemented to enable this to be used in HashMap
 * 
 * In this case I am going to use a String data type for testing as it 
 * already has a well-defined hashCode method
 * 
 */
public class Cache<T> {
	private Calendar calendar = Calendar.getInstance();
	private HashMap<T,CacheNode<T>> map = null;
	private CacheNode<T> head = null; // most recently used
	private CacheNode<T> tail = null; // least recently used
 	private String type;
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
	public Cache(int maxSize,int initSize,String type){
		this.maxSize = maxSize;
		this.type = type;
		if(initSize <= maxSize){
			map = new HashMap<T,CacheNode<T>>(initSize);
		}else{
			map = new HashMap<T,CacheNode<T>>();
		}
	}
	
	public void add(T data){
		if(!map.containsKey(data)){
		   CacheNode<T> node = addToList(data);
		   map.put(data,node);
		}else{
		   map.get(data).incrementFrequency();
		}
	}
	
    public void print(){
    	CacheNode<T> temp = head;
    	while(temp!=null){
    		System.out.println(temp.data.toString());
    		temp = temp.next;
    	}
    }
	
	private CacheNode<T> addToList(T data){
		CacheNode<T> node = new CacheNode<T>(data);
		if(head == null){
			head = node;
			tail = head;
			size++;
		}else{			
			if(type.equals("LRU")){
			   if(!isFull()){
				   placeInList(node);
			   }else{
				  System.out.println("Trying to add "+data.toString()+" but the cache size is "+size);
				  makeSpace();
				  placeInList(node);
			   }
			}
		}
		return node;
	}
	
	private void makeSpace(){
		CacheNode<T> temp = tail;
		tail= temp.prev;
		temp.prev = null;
		tail.next = null;
		System.out.println("Removed LRU node with data = "+temp.data);
		System.out.println("tails is now at "+tail.data);
		//remove value from the map
		map.remove(temp.data);
		size--;
	}
	
	private void placeInList(CacheNode<T> node){
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}
	
	private boolean isFull(){
		return !(size<maxSize); 
	}
	
	private boolean isEmpty(){
		return !(size>0);
	}
	
	class CacheNode<T>{
		private long timestamp;
		private int frequency;
		private final T data;
		
		public CacheNode<T> next;
		public CacheNode<T> prev;
		
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
		Cache<String> stringCache = new Cache<String>(6,3,"LRU");
		stringCache.add("A");
		//stringCache.print();
		//System.out.println("Size of cache is "+stringCache.size);
		stringCache.add("B");
		stringCache.add("C");
		stringCache.add("D");
		stringCache.add("E");
		stringCache.add("F");
		stringCache.print();
		System.out.println("Size of cache is "+stringCache.size);
		stringCache.add("G");
		stringCache.print();
		System.out.println("Size of cache is "+stringCache.size);
		stringCache.add("H");
		stringCache.print();
		System.out.println("Size of cache is "+stringCache.size);
	}
}
