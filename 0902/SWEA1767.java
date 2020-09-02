package com.ssafy.java.algo.d0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 
 * @since
 * @see
 * @mem
 * @time
 * @caution 처음부터 다시 풀어보기
 * [고려사항] 문제 이해 어려움
 * [입력사항]
 * [출력사항]
 */

public class SWEA1767 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int T, N;
	static int[][] mx;
	static int[][] dirs = {
			{0, 1}, {1, 0}, {-1, 0}, {0, -1}	
	};
	static List<Mapping> core;
	static int MAXcore;
	static int MINline;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		StringTokenizer tokens = null;
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			
			mx = new int[N][N];
			core = new ArrayList<>();
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < N; c++) {
					mx[r][c] = Integer.parseInt(tokens.nextToken());
					if(mx[r][c] == 1 && r > 0 && r < N-1 && c > 0 && c < N-1) {
						core.add(new Mapping(r, c));
					}
				}
			}
			
			MINline = Integer.MAX_VALUE;
			MAXcore = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			output.append("#").append(t).append(" ").append(MINline).append("\n");
		}
		System.out.println(output);
	}
	
	static void dfs(int coreCnt, int cur, int lineCnt) {
		if(core.size() == cur) {
			if(MAXcore < coreCnt) {
				MAXcore = coreCnt;
				MINline = lineCnt;
			}
			else if(MAXcore == coreCnt){
				if(MINline > lineCnt) {
					MINline =lineCnt;
				}
			}
			return;
		}
		if(core.size() - cur + coreCnt < MAXcore) {
			return;
		}
		for(int d = 0; d < dirs.length; d++) {
			int r = core.get(cur).r;
			int c = core.get(cur).c;
			int visitedcnt = 0;
			while(true) {
				r += dirs[d][0];
				c += dirs[d][1];
				if(!isIn(r, c)) {
					break;
				}
				if(mx[r][c] == 1) {
					visitedcnt = 0;
					break;
				}
				visitedcnt++;
			}
			
			r = core.get(cur).r;
			c = core.get(cur).c;
			for(int i = 0; i < visitedcnt; i++) {
				r += dirs[d][0];
				c += dirs[d][1];
				mx[r][c] = 1;
			}
			
			if(visitedcnt == 0) {
				dfs(coreCnt, cur+1, lineCnt);
			}
			else {
				dfs(coreCnt+1, cur+1, lineCnt+visitedcnt);
				r = core.get(cur).r;
				c = core.get(cur).c;
				for(int i = 0; i < visitedcnt; i++) {
					r += dirs[d][0];
					c += dirs[d][1];
					mx[r][c] = 0;
				}
			}
			
		}
		
	}
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	static class Mapping{
		int r;
		int c;
		public Mapping(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Mapping [r=" + r + ", c=" + c + "]";
		}
		
	}
	static String src = "3\r\n" + 
			"7\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"1 1 0 1 0 0 0\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"9\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 1\r\n" + 
			"11\r\n" + 
			"0 0 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 1 0 0\r\n" + 
			"0 1 0 1 1 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0";
}
