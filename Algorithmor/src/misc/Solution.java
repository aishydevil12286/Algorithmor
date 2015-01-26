package misc;

public class Solution {
	
	public static int solution(String S) {
        StringBuilder sb = new StringBuilder(S);
        sb.append(S);
        System.out.println(sb.toString());
        
        int len = S.length();
        System.out.println(len);
        int automor = 1;
        
        String cycle;
                
        for(int i=1;i<len;i++){
        	cycle = sb.substring(i,i+len);
        	System.out.println(cycle);
        	
        	if(cycle.equals(S)){
        		automor++;
        	}
        }
        return automor;
    }

	public static void main(String[] args) {
		String s = "babababababababababababababababababababababababababa";
		String c = "codility";
		System.out.println(solution(s));
		

	}

}
