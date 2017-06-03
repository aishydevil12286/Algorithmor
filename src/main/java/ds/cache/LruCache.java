package ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * A simple LRU cache using LinkedhashMap which uses a cyclic doubly linked list starting with a header(Entry object)
 * 
 *  [header] <->  ["a"] <-> ["b"] <-> ["c"] <-> ["d"] <-> [header]
 */

public class LruCache<K,V> extends LinkedHashMap<K,V> {
	
	private static final long serialVersionUID = 6221148858525918003L;	
	private final int capacity;
	private long accessCount = 0;
	private long hitCount = 0;
	
	public LruCache(int capacity,float loadFactor)
	{
	super(capacity,loadFactor,true);
	this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
	{
		return this.size() > capacity;
	}
	
	/*
	 * Getters and setters
	 */

	public long getAccessCount() {
		return accessCount;
	}

	public long getHitCount() {
		return hitCount;
	}
}
