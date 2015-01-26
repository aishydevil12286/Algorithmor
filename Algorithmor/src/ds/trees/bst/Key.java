package ds.trees.bst;

public class Key<K extends Comparable<K>> {
	
	private final K value;
	
	public Key(K value){
		this.value = value;
	}
	
	public K getValue(){
		return value;
	}
	
	public Comparison compareTo(Key<K> key){
		int cmp = this.value.compareTo(key.getValue());
		if(cmp <0){
			return Comparison.LESS;
		}else if(cmp>0){
			return Comparison.GREATER;
		}else{
			return Comparison.EQUAL;
		}
	}
	
	public static enum Comparison{LESS,EQUAL,GREATER};

}
