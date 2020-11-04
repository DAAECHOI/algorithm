package com.ssafy.java.algo.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5643 {
	static int T;
	static int N, M;
	static int[] answer;
	static int cnt;
	static boolean[][] st;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			M = Integer.parseInt(input.readLine());
			
			st = new boolean[N][N];
			
			for(int m = 0; m < M; m++) {
				tokens = new StringTokenizer(input.readLine());
				int a = Integer.parseInt(tokens.nextToken())-1;
				int b = Integer.parseInt(tokens.nextToken())-1;
				st[a][b] = true;
			}

			for (int k = 0; k < N; k++) { // 경유지
				for (int i = 0; i < N; i++) { // 출발지
					for (int j = 0; j < N; j++) { // 도착지
						if(st[i][k] && st[k][j]) {
							st[i][j] = true;
						}
					}
				}
			}

			answer = new int[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(st[i][j]) {
						answer[i]++;
						answer[j]++;
					}
				}
			}
			
			cnt = 0;
			for(int i = 0; i < N; i++) {
				if(answer[i] == N-1) {
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
	static String src = "1\r\n" + 
			"6\r\n" + 
			"6\r\n" + 
			"1 5\r\n" + 
			"3 4\r\n" + 
			"5 4\r\n" + 
			"4 2\r\n" + 
			"4 6\r\n" + 
			"5 2";
}
