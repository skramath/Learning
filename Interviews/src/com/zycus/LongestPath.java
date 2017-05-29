package com.zycus;

public class LongestPath {
	
	
	public int[][] solution;
	public LongestPath(int N) {
			solution = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solution[i][j] = 0;
				}
			}
	}
	
	
	
	
	public static void main(String[] args) {
		
		int N = 5;
		int[][] maze = 
			{ 
				{ 1, 0, 1, 1,1 }, 
				{ 1, 1, 1, 0,1 }, 
				{ 0, 0,0, 1, 1 },
				{ 0, 0, 0, 1,0 },
				{ 0, 0,0, 1, 1 } 
			};
		LongestPath path = new LongestPath(N);
		
	}

}
