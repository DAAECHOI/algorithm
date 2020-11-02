package com.ssafy.java.algo.d1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA4014 {
	
	static int T;
	static int N, X;
	static int[][] map1;
	static int[][] map2;
	static boolean[][] check;
	static int total;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		
		for(int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			X = Integer.parseInt(tokens.nextToken());
			map1 = new int[N][N];
			map2 = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < N; c++) {
					map1[r][c] = Integer.parseInt(tokens.nextToken());
					map2[c][r] = map1[r][c];
				}
			}
			total = 0;
			System.out.println("#" + t + " " + (build(map1) + build(map2)));
		}

	}

	static int build(int[][] map) {
		check = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			int cnt = 0;
			int front = map[r][0];
			boolean flag = false;
			for(int c = 0; c < N; c++) {
				if(map[r][c] == front) {
					cnt++;
				}
				else if(map[r][c] - front == 1) { //front가 작을 경우
					if(cnt >= X) {
						for(int i = c-X; i < c; i++) {
							if(front == map[r][i] && !check[r][i]) {
								flag = true;
							}
							else {
								flag = false;
								break;
							}
						}
						if(flag) {
							for(int i = c-X; i < c; i++) {
								check[r][i] = true;
								flag = false;
							}
							cnt++;
						}
					}
					else {
						break;
					}
				}
				else if(front - map[r][c] == 1) { //front가 클 경우
					if(N-cnt >= X) {
						int tmp = map[r][c];
						for(int i = c; i < c+X; i++) {
							if(tmp == map[r][i] && !check[r][i]) {
								flag = true;
							}
							else {
								flag = false;
								break;
							}
						}
						if(flag) {
							for(int i = c; i < c+X; i++) {
								check[r][i] = true;
								cnt++;
							}
							front = tmp;
							flag = false;
							c += X;
						}
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
			if(cnt == N) {
				total++;
			}
		}
		return total;
	}
	
	static String src = "10\r\n" + 
			"6 2\r\n" + 
			"3 3 3 2 1 1\r\n" + 
			"3 3 3 2 2 1\r\n" + 
			"3 3 3 3 3 2\r\n" + 
			"2 2 3 2 2 2\r\n" + 
			"2 2 3 2 2 2\r\n" + 
			"2 2 2 2 2 2\r\n" + 
			"6 4\r\n" + 
			"3 2 2 2 1 2 \r\n" + 
			"3 2 2 2 1 2 \r\n" + 
			"3 3 3 3 2 2 \r\n" + 
			"3 3 3 3 2 2 \r\n" + 
			"3 2 2 2 2 2 \r\n" + 
			"3 2 2 2 2 2 \r\n" + 
			"7 2\r\n" + 
			"1 1 1 1 2 1 1 \r\n" + 
			"1 1 1 2 2 2 1 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 \r\n" + 
			"8 3\r\n" + 
			"2 2 2 3 3 4 2 2 \r\n" + 
			"2 2 2 3 3 4 2 2 \r\n" + 
			"2 2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 2 2 2 2 \r\n" + 
			"2 2 2 2 1 1 2 2 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"8 4\r\n" + 
			"1 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"2 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 2 \r\n" + 
			"1 1 1 1 1 1 1 2 \r\n" + 
			"9 4\r\n" + 
			"4 4 3 3 3 3 2 2 2 \r\n" + 
			"4 4 3 3 1 1 2 2 3 \r\n" + 
			"3 3 2 2 1 1 1 1 2 \r\n" + 
			"1 1 1 1 1 1 1 1 1 \r\n" + 
			"1 1 1 1 1 1 1 1 1 \r\n" + 
			"2 2 1 1 1 1 1 1 1 \r\n" + 
			"2 2 1 1 1 1 1 1 1 \r\n" + 
			"2 2 2 2 2 2 1 1 1 \r\n" + 
			"3 3 3 3 2 2 2 2 1 \r\n" + 
			"10 2\r\n" + 
			"2 2 3 5 3 1 1 1 1 1 \r\n" + 
			"2 2 3 5 3 1 1 1 1 1 \r\n" + 
			"3 3 4 5 4 3 2 1 1 2 \r\n" + 
			"3 3 4 5 4 3 2 1 1 2 \r\n" + 
			"5 5 5 5 5 5 3 1 1 3 \r\n" + 
			"4 4 4 5 5 5 4 3 3 3 \r\n" + 
			"4 4 4 5 5 5 5 5 5 3 \r\n" + 
			"4 4 4 4 4 5 5 5 5 3 \r\n" + 
			"4 4 4 4 4 5 5 5 5 3 \r\n" + 
			"5 5 4 4 4 5 5 5 5 4 \r\n" + 
			"12 4\r\n" + 
			"4 4 4 5 5 4 4 4 4 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 4 \r\n" + 
			"4 4 4 5 5 4 4 4 5 5 5 4 \r\n" + 
			"3 3 4 5 5 4 3 4 5 5 5 4 \r\n" + 
			"3 3 4 5 5 4 3 4 5 5 5 4 \r\n" + 
			"2 2 3 4 4 4 4 4 4 4 4 5 \r\n" + 
			"2 2 3 4 4 4 4 4 4 4 4 5 \r\n" + 
			"2 2 3 3 3 4 5 3 2 2 4 4 \r\n" + 
			"3 3 3 4 4 4 5 4 3 3 4 4 \r\n" + 
			"3 3 4 5 5 5 5 5 5 5 5 4 \r\n" + 
			"3 3 4 5 5 5 5 5 5 5 5 4 \r\n" + 
			"4 4 4 4 4 4 5 5 5 5 5 4 \r\n" + 
			"15 3\r\n" + 
			"5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \r\n" + 
			"5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \r\n" + 
			"5 5 5 5 4 4 2 2 3 4 4 4 4 4 5 \r\n" + 
			"5 4 4 3 3 3 2 2 3 4 4 4 4 4 4 \r\n" + 
			"5 3 3 1 2 2 3 3 3 4 4 4 4 4 4 \r\n" + 
			"3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \r\n" + 
			"3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \r\n" + 
			"2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \r\n" + 
			"2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \r\n" + 
			"3 4 4 4 4 4 3 3 3 3 3 3 4 4 4 \r\n" + 
			"5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \r\n" + 
			"5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \r\n" + 
			"5 5 5 5 4 4 4 4 3 3 2 2 3 3 4 \r\n" + 
			"5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \r\n" + 
			"5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \r\n" + 
			"20 3\r\n" + 
			"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
			"3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
			"5 3 3 2 2 2 2 2 3 3 4 4 4 4 5 5 5 5 5 5 \r\n" + 
			"4 3 3 1 1 1 1 1 2 3 4 4 4 5 5 5 5 5 5 5 \r\n" + 
			"4 2 2 1 1 1 1 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 3 3 2 2 2 2 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 4 4 4 4 3 3 2 3 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
			"4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
			"4 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"3 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"3 3 3 3 3 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 \r\n" + 
			"3 3 3 3 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 \r\n" + 
			"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
			"4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 4 4 4 4 4 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 3 3 4 4 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
			"5 5 5 5 5 5 5 5 4 4 4 4 3 3 3 3 4 4 4 4 \r\n" + 
			"";
}
