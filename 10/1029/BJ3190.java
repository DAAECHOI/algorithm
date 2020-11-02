package com.ssafy.java.algo.d1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ3190 {
	
	static int N, K, L;
	static int time;
	static int[][] karr;
	static int[] ltime;
	static char[] ldir;
	static int[][] map;
	static int[][] dirs = {
			{0,1}, {1,0}, {0,-1}, {-1,0}
	}; //우, 하, 좌, 상
	static Deque<Snake> snake = new LinkedList<>();
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		K = Integer.parseInt(input.readLine());
		karr = new int[K][2];
		for(int k = 0; k < K; k++) {
			tokens = new StringTokenizer(input.readLine());
			karr[k][0] = Integer.parseInt(tokens.nextToken())-1;
			karr[k][1] = Integer.parseInt(tokens.nextToken())-1;
			map[karr[k][0]][karr[k][1]] = 1;//사과 1
		}
		
		L = Integer.parseInt(input.readLine());
		ltime = new int[L];
		ldir = new char[L];
		for(int l = 0; l < L; l++) {
			tokens = new StringTokenizer(input.readLine()," ");
			ltime[l] = Integer.parseInt(tokens.nextToken());
			ldir[l] = tokens.nextToken().charAt(0);
		}

		move();
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(map[r][c]);
//			}
//			System.out.println();
//		}

		System.out.println(time);
	}
	
	static int move() {
		time = 0;
		int dir = 0;
		int r = 0, c = 0;
		map[r][c] = 2;//뱀 2
		int i = 0;//회전 시간
		
		snake.add(new Snake(r, c, dir));
		
		while(true) {
			time++;
			if(ltime[i] == time) {
				if(ldir[i] == 'L') {
					dir = 3;
				}
				else {
					dir = 2;
				}
				i++;
			}
			r = snake.peekLast().r;
			c = snake.peekLast().c;
			int nr = r + dirs[dir][0];
			int nc = c + dirs[dir][1];
			if(isIn(nr, nc) && map[nr][nc] < 2) {
				snake.addFirst(new Snake(nr, nc, dir));
				if(map[nr][nc] == 1) {
					map[nr][nc] = 2;
				}
				else {
					map[r][c] = 0;
					snake.pollLast();
				}
			}
			else {
				break;
			}
		}
		return time;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
	
	static class Snake{
		int r;
		int c;
		int dir;
		
		public Snake(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static String src = "6\r\n" + 
			"3\r\n" + 
			"3 4\r\n" + 
			"2 5\r\n" + 
			"5 3\r\n" + 
			"3\r\n" + 
			"3 D\r\n" + 
			"15 L\r\n" + 
			"17 D";
}
