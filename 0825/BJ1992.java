package com.ssafy.java.algo.d0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ1992 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N][N];
		String line;
		for(int r = 0; r < N; r++) {
			line = input.readLine();
			for(int c = 0; c < N; c++) {
				arr[r][c] = line.charAt(c) - '0';
			}
		}

		search(0, 0, N);
		System.out.println(output);
		
	}
	static boolean isAble(int r, int c, int size) {
		int tmp = arr[r][c];
		
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(tmp != arr[i][j])
					return false;
			}
		}
		return true;
	}
	
	static void search(int r, int c, int size) {
		if(isAble(r, c, size)){
			output.append(arr[r][c]);
		}
		else { 
			output.append("(");
			search(r, c, size/2);
			search(r, c+size/2, size/2);
			search(r+size/2, c, size/2);
			search(r+size/2, c+size/2, size/2);
			output.append(")");
		}
	}
	
	static String src = "8\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"00011100\r\n" + 
			"00011100\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"11110011\r\n" + 
			"11110011";
}
