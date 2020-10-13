package com.ssafy.java.algo.d0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author
 * @since
 * @see
 * @mem
 * @time
 * @caution cnt++와 cnt+1 유의하기
 * visited 사용 제대로 파악하기
 */

public class BJ1987 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int R, C;
	static char[][] board;
	static boolean[] alpa;

	static int[][] dirs = {
			{0, 1}, {1, 0}, {-1, 0}, {0, -1}	
	};
	static int MAX;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		board = new char[R][];
		alpa = new boolean[26];
		for(int r = 0; r < R; r++) {
			board[r] = input.readLine().toCharArray();
		}

		MAX = Integer.MIN_VALUE;
		getDist(0, 0, 1);
		System.out.println(MAX);
	}
	
	static void getDist(int r, int c, int cnt) {
		alpa[board[r][c]-'A'] = true;
		
		for(int d = 0; d < dirs.length; d++) {
			int nr = r + dirs[d][0];
			int nc = c + dirs[d][1];
			if(isIn(nr, nc) && !alpa[board[nr][nc]-'A']) {
				getDist(nr, nc, cnt+1);
			}
		}
		MAX = Math.max(MAX, cnt);
		alpa[board[r][c]-'A'] = false;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static String src = "3 4\r\n" + 
			"ABCD\r\n" + 
			"BCDA\r\n" + 
			"CDEF";
}
