package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
/**
 * @author DAAECHOI
 * @date 2020. 8. 17
 * @see
 * @mem 13152KB
 * @time 84ms
 * @caution
 * [고려사항] 재귀문제 연습 필요
 * [입력사항]
 * [출력사항]
 */
public class BJ14510 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;
	static CS[] cs;
	static boolean[] visited;
	static int MAX;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer tokens = null;
		
		N = Integer.parseInt(input.readLine());
		cs = new CS[N+1];
		
		for(int n = 1; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			cs[n] = new CS(x, y);
		}
		
		MAX = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			MAX = Math.max(search(i, 0), MAX);
		}
		System.out.println(MAX);
	}

	static int search(int cur, int cost) {
		if(cur + cs[cur].time == N+1) {
			return cost += cs[cur].cost;
		}
		if(cur + cs[cur].time > N+1) {
			return cost;
		}
		for(int i = cur + cs[cur].time; i <= N; i++) {
			MAX = Math.max(search(i, cost + cs[cur].cost), MAX);
		}
		return MAX;
	}
	
	static class CS{
		int time;
		int cost;
		
		public CS() {}
		
		public CS(int time, int cost) {
			this.time = time;
			this.cost = cost;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return String.format("CS [time=%s, cost=%s]", time, cost);
		}
		
	}
	
	static String src = "10\r\n" + 
			"5 50\r\n" + 
			"4 40\r\n" + 
			"3 30\r\n" + 
			"2 20\r\n" + 
			"1 10\r\n" + 
			"1 10\r\n" + 
			"2 20\r\n" + 
			"3 30\r\n" + 
			"4 40\r\n" + 
			"5 50";
}
