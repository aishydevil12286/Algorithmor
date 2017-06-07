package ds.sets;

import java.util.HashSet;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class FindNumberOfIslands extends WeightedQuickUnionUF{
	private int[][] matrix;
	private int N;
	private int M;
	
	public FindNumberOfIslands(int[][] matrix) {
		super(matrix.length*matrix[0].length);
		this.matrix = matrix;
		this.N = matrix.length;
		this.M = matrix[0].length;
	}
	
	@Override
	public int count(){
		HashSet<Integer> uniques = new HashSet<Integer>();
		for(int i : parent){
			if(i!= M*N+1 && !uniques.contains(i)){
				uniques.add(i);
			}
		}
		return uniques.size();
	}
	
	public void findIslands(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(matrix[i][j]==0){
					parent[i*M+j]=M*N+1;
					continue;
				}
				
				// Check all neighbours for connections
				
				// Top Left neighbour
				if((i-1)>=0 && (j-1)>=0 && matrix[i-1][j-1]==1){
					this.union(i*M+j,(i-1)*M+(j-1));
				}
				// Top neighbour
				if((i-1)>=0 && matrix[i-1][j]==1){
					this.union(i*M+j,(i-1)*M+j);
				}
				// Top Right neighbour
				if((i-1)>=0 && (j+1)<M && matrix[i-1][j+1]==1){
					this.union(i*M+j,(i-1)*M+(j+1));
				}
				// Left neighbour
				if((j-1)>=0 && matrix[i][j-1]==1){
					this.union(i*M+j,(i)*M+(j-1));
				}
				// Right neighbour
				if((j+1)<M && matrix[i][j+1]==1){
					this.union(i*M+j,(i)*M+(j+1));
				}
				// Bottom Left neighbour
				if((i+1)<N && (j-1)>=0 && matrix[i+1][j-1]==1){
					this.union(i*M+j,(i+1)*M+(j-1));
				}
				// Bottom neighbour
				if((i+1)<N && matrix[i+1][j]==1){
					this.union(i*M+j,(i+1)*M+(j-1));
				}
				// Bottom Right neighbour
				if((i+1)<N && (j+1)<M && matrix[i+1][j+1]==1){
					this.union(i*M+j,(i+1)*M+(j+1));
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[][] a = new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}};
        FindNumberOfIslands test = new FindNumberOfIslands(a);
        test.findIslands();
        System.out.println("Number of Islands is: " +test.count());
	}
}
