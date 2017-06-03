package algo.backtracking;

import java.util.ArrayList;

public class NQueen {
	ArrayList<int[]> Solutions = new ArrayList<int[]>();
    int N = 0;
	public void findPositions(int N){
		this.N = N;
		int[][] board = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(board[i][j]!= -1){
					placeQueen(board,i,j);
					
				}
			}
		}
	}
	
	public void placeQueen(int[][]board,int row,int col){
		board[row][col] = 0;
		for(int i=0;i<N&&i!=col;i++){
			board[row][i] = -1;
			board[i][row] = -1;
		}
		for(int i=row,j=col;Math.abs(N-i)>1&&Math.abs(N-j)>1;i++,j++){
			board[row+1][col+1] = -1;
			board[row+1][col-1] = -1;
			board[row-1][col+1] = -1;
			board[row-1][col-1] = -1;
		}
	}
	

	public void resetBoard(int[] board){
		int rows = board.length;
		for(int i=0;i<rows;i++){
			board[i]=-1;
		}
	}
	
	public void resetRow(int[] board, int row){
		board[row] = -1;
	}
	
	
	
}
