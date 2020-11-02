package com.ssafy.java.algo.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA1952 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int T;
	static int[] tickets;
	static int[] months;
	static int answer;
	static boolean[] visited;
	static int MIN;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		StringTokenizer tokens = null;
		for(int t = 1; t <= T; t++) {
			tickets = new int[4];
			months = new int[12];
			visited = new boolean[12];
			
			tokens = new StringTokenizer(input.readLine());
			for(int n = 0; n < tickets.length; n++) {
				tickets[n] =  Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(input.readLine());
			for(int n = 0; n < months.length; n++) {
				months[n] =  Integer.parseInt(tokens.nextToken());
			}
			
			MIN = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + t + " " + MIN);
		}
		
	}
	
	static void dfs(int midx, int cost) {
		if(midx >= months.length) {
			MIN = Math.min(cost, MIN);
			return;
		}
		if(cost > MIN) {
			return;
		}
		if(months[midx] == 0) {
			dfs(midx+1, cost);
		}
		dfs(midx+1, cost + tickets[0] * months[midx]);
		dfs(midx+1, cost + tickets[1]);
		dfs(midx+3, cost + tickets[2]);
		dfs(midx+1, tickets[3]);
	}
	
	static String src = "2\r\n" + 
			"10 40 100 300\r\n" + 
			"0 0 2 9 1 5 0 0 0 0 0 0\r\n" + 
			"10 100 50 300\r\n" + 
			"0 0 0 0 0 0 0 0 6 2 7 8";
}
