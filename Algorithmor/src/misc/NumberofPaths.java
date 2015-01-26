package misc;

public class NumberofPaths {
	
	public static int countPaths(int N){
		int count = 0;
		if(N == 1){
			count = 1;
		}else if(N == 2){
			count = 1+countPaths(1);
		}else if(N == 3){
			count = 1+countPaths(2)+countPaths(1);
		}
		else if(N >3){
			count = countPaths(N-1)+countPaths(N-2)+countPaths(N-3);
		}		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(NumberofPaths.countPaths(5));

	}

}
