package questions.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxUniqueSubString {
	
	public static String maxUniqueSubstring(String s){		
		int strlen = s.length();
		StringBuilder sb = new StringBuilder(strlen); // Use StringBuilder to save memory.
		String previousMax = ""; // The previous Max substring encountered
		String max = ""; // The current max substring
		boolean updateFlag = false; // Should max be updated from the StringBuilder
		Map<Character,Integer> fMap = new HashMap<Character,Integer>();
		
		for(int i=0;i<strlen;i++){
			Character nextChar = s.charAt(i);
			if(fMap.containsKey(nextChar)){ //character already present in current max
				// check whether to update max
				if(updateFlag){
					max = sb.toString();
					updateFlag=false;
				}
				sb = new StringBuilder(); // reset the StringBuilder
				sb.append(nextChar); 
				fMap.clear(); 
				fMap.put(nextChar,1); 
				// update previousMax if current max is longer
				if(max.length()>previousMax.length()){
				previousMax = max;
				}
			}else{
				// keep adding character to the builder
				sb = sb.append(nextChar);
				fMap.put(nextChar,1);
				if(max.length() < sb.length() && updateFlag==false){
					updateFlag=true; // Set the flag to update max when a duplicate occurs
				}
			}
		}
		// choose the maximum between previousMax and max
		if(previousMax.length()>max.length()){
			max = previousMax;
		}
		return max;
	}
	
	public static void main(String[] args){
		String x = "aasdklnadcjaclanlasdajkapkvoirupge";
		System.out.println(x);
		System.out.println(maxUniqueSubstring(x));
	}

}
