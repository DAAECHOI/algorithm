package com.ssafy.java.algo.d0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class JO1681 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[][] grid;
	static int MIN;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		grid = new int[N][N];
		visited = new boolean[N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				grid[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		MIN = Integer.MAX_VALUE;
		visited[0] = true;
		makePerm(N-1, visited, 0, 0);
		System.out.println(MIN);
	}
	static void makePerm(int r, boolean[] visited, int pre, int cost) {
		if(cost > MIN)
			return;
		if(r == 0) {
			if(grid[pre][0] > 0) {
				MIN = Math.min(MIN, cost + grid[pre][0]);
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i] && grid[pre][i] > 0) {
				visited[i] = true;
				makePerm(r-1, visited, i, cost + grid[pre][i]);
				visited[i] = false;
			}
		}
	}
	static String src = "7\r\n" + 
			"0 80 7 0 41 0 53 \r\n" + 
			"19 0 91 24 91 0 76 \r\n" + 
			"53 96 0 41 35 5 0 \r\n" + 
			"16 30 67 0 69 36 45 \r\n" + 
			"0 55 30 15 0 3 16 \r\n" + 
			"91 0 0 67 43 0 63 \r\n" + 
			"0 82 42 0 64 65 0 ";
}
