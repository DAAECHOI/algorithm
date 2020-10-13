package com.ssafy.java.algo.d0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14889 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;
	static int[][] team;
	static int N;
	static int MIN;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		team = new int[N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				team[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		MIN = Integer.MAX_VALUE;
		makeComb(N/2, 0, new boolean[N]);
		System.out.println(MIN);
		
	}
	static void makeComb(int r, int start, boolean[] visited) {
		if(r == 0) {
			int[] st = new int[N/2];
			int[] link = new int[N/2];
			for(int i = 0, a = 0, b = 0; i < N; i++) {
				if(visited[i]) {
					st[a++] = i;
				}
				else{
					link[b++] = i;
				}
			}
			MIN = Math.min(MIN, Math.abs(play(st) - play(link)));
			return;
		}
		for(int i = start; i < N; i++) {
			visited[i] = true;
			makeComb(r-1, i+1, visited);
			visited[i] = false;
		}
	}
	static int play(int[] stat) {
		int sum = 0;
		for(int i = 0; i < stat.length; i++) {
			for(int j = 0; j < stat.length; j++) {
				sum += team[stat[i]][stat[j]];
			}
		}
		return sum;
	}
	static String src = "8\r\n" + 
			"0 5 4 5 4 5 4 5\r\n" + 
			"4 0 5 1 2 3 4 5\r\n" + 
			"9 8 0 1 2 3 1 2\r\n" + 
			"9 9 9 0 9 9 9 9\r\n" + 
			"1 1 1 1 0 1 1 1\r\n" + 
			"8 7 6 5 4 0 3 2\r\n" + 
			"9 1 9 1 9 1 0 9\r\n" + 
			"6 5 4 3 2 1 9 0";
}
