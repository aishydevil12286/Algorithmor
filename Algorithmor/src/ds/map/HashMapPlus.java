package ds.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMapPlus<K,V extends Comparable<V>> extends HashMap<K,V>{

	private static final long serialVersionUID = 6045421194501273817L;

	public HashMap<K,V> sortByValue(HashMap<K,V> hashMap){
		
		// create a list of EntrySets in the HashMap
		List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(hashMap.entrySet());
		
		// Declare a new Comparator that will compare the values
		Comparator<Map.Entry<K,V>> valueComparator = new Comparator<Map.Entry<K,V>>(){
			@Override
			public int compare(Map.Entry<K,V> left, Map.Entry<K,V> right){
				return left.getValue().compareTo(right.getValue());
			}
		};
    		   
    	// Sort the List base don values
		Collections.sort(list,valueComparator);
		
		// return a HashMap created from the ArrayList
		HashMap<K,V> sortedMap = new HashMap<K,V>(hashMap.size());
		Iterator<Map.Entry<K,V>> iterator = list.iterator();
		while(iterator.hasNext()){
			Map.Entry<K,V> entry = iterator.next();
			sortedMap.put(entry.getKey(),entry.getValue());
		}
		return sortedMap;
	}
}
