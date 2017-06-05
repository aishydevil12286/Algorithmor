package algo.backtracking;

public class SudokuSolver {
	
	public static boolean solveSudoku(int[][] sud){
		int N = sud.length;		
		Location unassigned = findUnassignedLocations(sud);
		if(unassigned == null){
			// Sudoku solved. Print the solution
			//printSolution(sud);
			return true;
		}
		
		int row = unassigned.getRow();
		int col = unassigned.getCol();
		
		// Try placing digits 1 - 9 on this location
		for(int i=1;i<9;i++){
			if(isSafe(sud,row,col,i)){
				sud[row][col]=i;
				if(solveSudoku(sud)){
					//printSolution(sud);
					return true;
				}
				// if we are still here then the recursive solution failed
				// Unset the value and try again
				sud[row][col] = 0;
			}
		}
		// for backtracking
		return false;
	}
	
	public static void printSolution(int[][] arr){
		System.out.println("------------");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(" "+arr[i][j]);
			}
			System.out.println("");
		}
		System.out.println("------------");
	}
	
	public static Location findUnassignedLocations(int[][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr.length;col++){
				if(arr[row][col] == 0){
					return new Location(row,col);
				}
			}
		}	
		return null;
	}
	
	public static boolean inRow(int[][] arr,int row,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[row][i]==num){
				return true;
			}
		}
		return false;
	}
	
	public static boolean inCol(int[][] arr,int col,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i][col]==num){
				return true;
			}
		}
		return false;
	}
	
	public static boolean inBox(int[][] arr,int row,int col,int num){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){				
				if(arr[i+row][j+col]==num){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafe(int[][] arr, int row, int col, int num){
		// For checking in box we always use the row,col for the starting index of box
		return !inRow(arr,row,num) && !inCol(arr,col,num) && !inBox(arr,(row-row%3),(col-col%3),num);
	}

	public static void main(String[] args) {
		int[][] sudoku = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
		                  {5, 2, 0, 0, 0, 0, 0, 0, 0},
		                  {0, 8, 7, 0, 0, 0, 0, 3, 1},
		                  {0, 0, 3, 0, 1, 0, 0, 8, 0},
		                  {9, 0, 0, 8, 6, 3, 0, 0, 5},
		                  {0, 5, 0, 0, 9, 0, 6, 0, 0},
		                  {1, 3, 0, 0, 0, 0, 2, 5, 0},
		                  {0, 0, 0, 0, 0, 0, 0, 7, 4},
		                  {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		boolean b = solveSudoku(sudoku);
		if(b){
			printSolution(sudoku);
		}
		System.out.println(b);
	}
	
	private static class Location{
		int row;
		int col;
				
		public Location(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		public int getRow() {
			return row;
		}
		public int getCol() {
			return col;
		}
	}

}
