package algo.backtracking;

/*
 * http://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
 * https://www.youtube.com/watch?v=xouin83ebxE
 */

public class NQueenSolutions {
	
	public static void findSolutions(int[][] board, int[] rowX, int[] colX, int col,int N){
		if(col == N){
			printSolution(board,N);
		}
		
		for(int i=0;i<N;i++){
			// if safe then place the Queen
			if(isSafe(board,rowX,colX,i,col,N)){
				board[i][col]=1;
				rowX[i]++;
				colX[col]++;
				findSolutions(board,rowX,colX,col+1,N);
				board[i][col]=0;
				rowX[i]--;
				colX[col]--;
			}
		}
	}
		
	public static boolean isSafe(int[][] board,int[] rowX,int[] colX, int row, int col,int N){
		boolean result = true;
		// Check for direct horizontal and vertical attacks
		if(rowX[row] >0 || colX[col] >0){
			return false;
		}
		
		// Check for top-left diagonal attacks
		for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		
		// Check for bottom-right diagonal attacks
		for(int i=row,j=col;i<N && j<N;i++,j++){
			if(board[i][j]==1){
				return false;
			}
		}
		
		// Check for bottom-left diagonal attacks
		for(int i=row,j=col;i<N && j>=0;i++,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		
		// Check for top-right diagonal attacks
		for(int i=row,j=col;i>=0 && j<N;i--,j++){
			if(board[i][j]==1){
				return false;
			}
		}
		
		return result;
	}
	
	public static void printSolution(int[][] board,int N){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board[i][j]==1){
					System.out.print(" Q ");
				}else{
					System.out.print(" X ");
				}
			}
			System.out.println("");
		}
		System.out.println("------------");
	}

	public static void main(String[] args) {
		int N = 1;
		int[][] board = new int[N][N];
		int[] rowX = new int[N];
		int[] colX = new int[N];
		
		findSolutions(board,rowX,colX,0,N);
	}

}
