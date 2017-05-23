package ds.caching;

import java.util.LinkedHashMap;

public class LRUCache implements Cache<K,V>{
	private Map<K,V> cache;
	
	public LRUCache(){
		this.cache = new ConcurrentLinkedHashMap<>();
	}

	@Override
	public void add(K key, V data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
