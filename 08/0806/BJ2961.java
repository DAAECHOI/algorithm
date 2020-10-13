package com.ssafy.java.algo.d0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2961 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[][] ingr;
	static boolean[] visited;
	static long minValue;
	
	public static void main(String[] args) throws IOException {

		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		
		ingr = new int[N][2];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
			ingr[i][0] = Integer.parseInt(tokens.nextToken());
			ingr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		minValue = Integer.MAX_VALUE;
		for(int n = 1; n <= N; n++) {
			cook(n, 0, new int[n][2]);
		}
		
		System.out.println(minValue);
	}

	static long multS(int[][] sTmp) {
		long mult = 1;
		for(int s = 0; s < sTmp.length; s++)
			mult *= sTmp[s][0];
		return mult;
	}
	
	static long sumB(int[][] bTmp) {
		long sum = 0;
		for(int b = 0; b < bTmp.length; b++)
			sum += bTmp[b][1];
		return sum;
	}
	
	static void cook(int r, int start, int[][] tmp) {
		if(r == 0) {
			if(minValue > Math.abs(multS(tmp)-sumB(tmp)))
				minValue = Math.abs(multS(tmp)-sumB(tmp));
			return;
		}
		else {
			for(int i = start; i < N; i++) {
				if (!visited[i]) {
	                visited[i] = true;
					tmp[r-1][0] = ingr[i][0];
					tmp[r-1][1] = ingr[i][1];
					cook(r-1, i+1, tmp);
					visited[i] = false;
	            }
			}
		}
		
	}
	static String src = "1\r\n" + 
			"4 9";
}