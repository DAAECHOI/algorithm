package com.ssafy.java.algo.d1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {

	static int T;
	static int N;
	static int W, H;
	static int[][] map, copymap;
	static int MIN;
	static Queue<Mapping> queue = new LinkedList<>();
	static boolean[][] visited;
    static int[][] dirs = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			map = new int[H][W];
			copymap = new int[H][W];
			
			for(int r = 0; r < H; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < W; c++) {
					copymap[r][c] = map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			MIN = Integer.MAX_VALUE;
			makeStart(N, new int[N]);
			
	    	System.out.println("#" + t + " " + MIN);
		}
    	
	}
	
	static void makeStart(int r, int[] temp) {
		if(r == 0) {
			copy();
			for(int i = 0; i < temp.length; i++) {
				visited = new boolean[H][W];
				for(int h = 0; h < H; h++) {
					if(map[h][temp[i]] > 0) {
						bfs(new Mapping(h, temp[i], map[h][temp[i]]));
						break;
					}
				}
				endturn();
			}
			MIN = Math.min(MIN, count());
			return;
		}
		for (int i = 0; i < W; i++) {
			temp[r - 1] = i;
			makeStart(r - 1, temp);
		}
	}
	
	private static int count() {
		int cnt = 0;
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				if(map[h][w] > 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void copy() {
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				map[h][w] = copymap[h][w];
			}
		}
	}

	private static void endturn() {
		Queue<Integer> queue = new LinkedList<>();
		for(int w = 0; w < W; w++) {
			for(int h = 0; h < H; h++) {
				if(map[h][w] > 0) {
					queue.offer(map[h][w]);
					map[h][w] = 0;
				}
			}
			for(int h = H-queue.size(); h < H; h++) {
				map[h][w] = queue.poll();
			}
		}
	}

	private static void bfs(Mapping m) {
		queue.offer(m);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(--size >= 0) {
				Mapping front = queue.poll();
				for(int i = 0; i < front.range; i++) {
					for(int d = 0; d < dirs.length; d++) {
						int nr = front.r + dirs[d][0] * i;
						int nc = front.c + dirs[d][1] * i;
						if(isIn(nr, nc) && !visited[nr][nc]) {
							queue.offer(new Mapping(nr, nc, map[nr][nc]));
							visited[nr][nc] = true;
							map[nr][nc] = 0;
						}
					}
				}
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}
	
	static class Mapping{
		int r;
        int c;
        int range;
        
        public Mapping(int r, int c, int range) {
            this.r = r;
            this.c = c;
            this.range = range;
        }
	}
	
	static String src = "5\r\n" + 
			"3 10 10\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 0 0 0 0\r\n" + 
			"1 0 3 0 1 1 0 0 0 1\r\n" + 
			"1 1 1 0 1 2 0 0 0 9\r\n" + 
			"1 1 4 0 1 1 0 0 1 1\r\n" + 
			"1 1 4 1 1 1 2 1 1 1\r\n" + 
			"1 1 5 1 1 1 1 2 1 1\r\n" + 
			"1 1 6 1 1 1 1 1 2 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 5\r\n" + 
			"1 1 7 1 1 1 1 1 1 1\r\n" + 
			"2 9 10\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 1 0 0 0 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 1 1 1 1 1 1 0\r\n" + 
			"1 1 3 1 6 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1 1 1\r\n" + 
			"3 6 7\r\n" + 
			"1 1 0 0 0 0\r\n" + 
			"1 1 0 0 1 0\r\n" + 
			"1 1 0 0 4 0\r\n" + 
			"4 1 0 0 1 0\r\n" + 
			"1 5 1 0 1 6\r\n" + 
			"1 2 8 1 1 6\r\n" + 
			"1 1 1 9 2 1\r\n" + 
			"4 4 15\r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 5 0 \r\n" + 
			"1 1 1 0 \r\n" + 
			"1 1 1 9 \r\n" + 
			"1 1 1 1 \r\n" + 
			"1 6 1 2 \r\n" + 
			"1 1 1 5 \r\n" + 
			"1 1 1 1 \r\n" + 
			"2 1 1 2 \r\n" + 
			"4 12 15\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9";
}
