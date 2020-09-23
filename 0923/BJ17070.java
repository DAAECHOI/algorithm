package com.ssafy.java.algo.d0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ17070 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int[][] arr;
	static int[][] dirs = {
			{0,1},{1,0},{1,1}	
	};
	static int answer;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		arr = new int[N][N];
		for(int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for(int m = 0; m < N; m++) {
				arr[n][m] = Integer.parseInt(tokens.nextToken());
			}
		}

		answer = 0;
		dfs(0,1,1);
		System.out.println(answer);
	}
	
	static void dfs(int r, int c, int ch) {
		if(r == N-1 && c == N-1) {
			answer++;
			return;
		}
		
		if(ch == 1) { //가로
			if(isIn(r+dirs[0][0], c+dirs[0][1])) {
				dfs(r+dirs[0][0], c+dirs[0][1], 1);
			}
			if(isIn(r+dirs[0][0], c+dirs[0][1]) && isIn(r+dirs[1][0], c+dirs[1][1]) && isIn(r+dirs[2][0], c+dirs[2][1])) {
				dfs(r+dirs[2][0], c+dirs[2][1], 3);
			}
		}
		else if(ch == 2) { //세로
			if(isIn(r+dirs[1][0], c+dirs[1][1])) {
				dfs(r+dirs[1][0], c+dirs[1][1], 2);
			}
			if(isIn(r+dirs[0][0], c+dirs[0][1]) && isIn(r+dirs[1][0], c+dirs[1][1]) && isIn(r+dirs[2][0], c+dirs[2][1])) {
				dfs(r+dirs[2][0], c+dirs[2][1], 3);
			}
		}
		else { //대각선
			if(isIn(r+dirs[0][0], c+dirs[0][1])) {
				dfs(r+dirs[0][0], c+dirs[0][1], 1);
			}
			if(isIn(r+dirs[1][0], c+dirs[1][1])) {
				dfs(r+dirs[1][0], c+dirs[1][1], 2);
			}
			if(isIn(r+dirs[0][0], c+dirs[0][1]) && isIn(r+dirs[1][0], c+dirs[1][1]) && isIn(r+dirs[2][0], c+dirs[2][1])) {
				dfs(r+dirs[2][0], c+dirs[2][1], 3);
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r < N && c < N && arr[r][c] == 0;
	}
	static String src="6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0";
}
