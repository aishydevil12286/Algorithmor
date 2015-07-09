package ds.cache;

/*
 * An cache interface can generically store values indexed by hashcode of keys. For object types that have 
 * efficient hashCode methods already existing or 
 */
public interface Cache<K,V> {

	/*
	 * Adds the Key value pair in the cache
	 */
	public void add(K key,V data);
	
	/*
	 * Checks if the cache contains a key 
	 */
	public boolean containsKey(K key);
	
	/*
	 * Checks if the cache contains a value
	 */
	public boolean containsValue(V data);
	
	/*
	 * Returns the value associated with the key
	 */
	public V get(K key);
	
	/*
	 * Boolean flag after checking whether cache is full
	 */
	public boolean isFull();
	
	/*
	 * Boolean flag after checking whether cache is empty
	 */
	public boolean isEmpty();
	
	/*
	 * clears the cache
	 */
	public void clear();

}
