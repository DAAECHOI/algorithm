package com.ssafy.java.algo.d0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ9205 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, T;
	static Map[] arr;
	static int[][] map;
	static int r, c;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine()) + 2;
			arr = new Map[N];
			map = new int[N][N];

			tokens = new StringTokenizer(input.readLine());
			r = Integer.parseInt(tokens.nextToken());
			c = Integer.parseInt(tokens.nextToken());
			arr[0] = new Map(r, c);

			for (int n = 0; n < N-2; n++) {
				tokens = new StringTokenizer(input.readLine());
				r = Integer.parseInt(tokens.nextToken());
				c = Integer.parseInt(tokens.nextToken());
				arr[n + 1] = new Map(r, c);
			}

			tokens = new StringTokenizer(input.readLine());
			r = Integer.parseInt(tokens.nextToken());
			c = Integer.parseInt(tokens.nextToken());
			arr[N - 1] = new Map(r, c);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = 33000;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					int dist = Math.abs(arr[i].r - arr[j].r) + Math.abs(arr[i].c - arr[j].c);
					if (dist <= 1000) {
						map[i][j] = 1;
					}
				}
			}

			move();
			if (map[0][N - 1] > 0 && map[0][N - 1] < 33000) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}

	static void move() {
		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				for (int j = 0; j < N; j++) { // 도착지
					map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}
	}

	static class Map {
		int r;
		int c;

		public Map(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static String src = "2\r\n" + "2\r\n" + "0 0\r\n" + "1000 0\r\n" + "1000 1000\r\n" + "2000 1000\r\n" + "2\r\n"
			+ "0 0\r\n" + "1000 0\r\n" + "2000 1000\r\n" + "2000 2000";
}
