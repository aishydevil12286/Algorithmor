package algo.strings;

public class SubStringSearch {

	// returns the starting index of the first appearance of 
	// the pattern in the text
	public static int boyerMoore(String text,String pattern){
		int T = text.length();
		int P = pattern.length();
		
		for(int i=0;i<T;i++){
			
		}
		return 0;
	}
	
	private static boolean kmpMatch(String text,int lo,int hi,String pattern){
		int N = pattern.length()-1;
		for(int i=hi;i>=lo;i--){
			if (pattern.charAt(N)==text.charAt(hi)){
				N--;
			}
		}
		if(N<0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		boolean b = kmpMatch("ASVBDHCAAB",7,9,"AAB");
		System.out.println(b);
	}
}
