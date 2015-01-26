package misc;

import java.lang.Math;

public class PartitionProblem {
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        
	        int n = A.length;
	        int N =0;
	        for(int i=0;i<n;i++){
	            N += A[i];
	        }
	        boolean[][] P = new boolean[N/2+1][n+1];
	        for(int i=0;i<n;i++){
	            P[0][i] = true;
	        }
	        
	        for(int i = 1;i<=N/2;i++)
	            for(int j = 1;j<=n;j++)
	                if(A[j-1]<=i)
	                    P[i][j] = P[i][j-1] || P[i - A[j - 1]][ j - 1];
	                else
	                    P[i][j] = P[i][j-1];
	        if (P[N/2][n] == true)
	            return 1;
	        else 
	            return 0;
	    }
}
