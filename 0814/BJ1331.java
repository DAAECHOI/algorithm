package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
/**
 * @author DAAECHOI
 * @date 2020. 8. 17
 * @see
 * @mem 12976KB
 * @time 80ms
 * @caution
 * [고려사항] 체스 규칙을 몰라서 시간낭비한 문제
 * [입력사항]
 * [출력사항] 오타 확인
 */
public class BJ1331 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static Grid[] grid;
	static boolean[][] visited;
	static int[][] dirs = {
			{1, -2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}
	};
	public static void main(String[] args) throws IOException {
		
		input = new BufferedReader(new StringReader(src));
		grid = new Grid[36+1];
		visited = new boolean[6+1][6+1];
		for(int r = 1; r <= 36; r++) {
			String line = input.readLine();
			char x = line.charAt(0);
			int y = line.charAt(1) - '0';
			grid[r] = new Grid(x-64, y);
		}

		for(int r = 1; r < 36; r++) {
			for(int d = 0; d < dirs.length; d++) {
				int nx = grid[r].x + dirs[d][0];
				int ny = grid[r].y + dirs[d][1];
				if(isIn(nx, ny) && !visited[nx][ny] && nx == grid[r+1].x && ny == grid[r+1].y) {
					visited[nx][ny] = true;
					break;
				}
			}
		}
		
		for(int d = 0; d < dirs.length; d++) {
			int nx = grid[36].x + dirs[d][0];
			int ny = grid[36].y + dirs[d][1];
			if(isIn(nx, ny) && !visited[nx][ny] && nx == grid[1].x && ny == grid[1].y) {
				visited[nx][ny] = true;
				break;
			}
		}
		
		for(int r = 1; r <= 6; r++) {
			for(int c = 1; c <= 6; c++) {
				if(!visited[r][c]) {
					System.out.println("Invalid");
					return;
				}
			}
		}
		System.out.println("Valid");
		
	}
	
	static boolean isIn(int x, int y) {
		return x > 0 && y > 0 && x < 7 && y < 7;
	}
	
	static class Grid{
		int x;
		int y;
		public Grid() {}
		public Grid(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return String.format("Grid [x=%s, y=%s]", x, y);
		}
		
	}
	
	static String src = "A1\r\n" + 
			"B3\r\n" + 
			"A5\r\n" + 
			"C6\r\n" + 
			"E5\r\n" + 
			"F3\r\n" + 
			"D2\r\n" + 
			"F1\r\n" + 
			"E3\r\n" + 
			"F5\r\n" + 
			"D4\r\n" + 
			"B5\r\n" + 
			"A3\r\n" + 
			"B1\r\n" + 
			"C3\r\n" + 
			"A2\r\n" + 
			"C1\r\n" + 
			"E2\r\n" + 
			"F4\r\n" + 
			"E6\r\n" + 
			"C5\r\n" + 
			"A6\r\n" + 
			"B4\r\n" + 
			"D5\r\n" + 
			"F6\r\n" + 
			"E4\r\n" + 
			"D6\r\n" + 
			"C4\r\n" + 
			"B6\r\n" + 
			"A4\r\n" + 
			"B2\r\n" + 
			"D1\r\n" + 
			"F2\r\n" + 
			"D3\r\n" + 
			"E1\r\n" + 
			"C2";
}
