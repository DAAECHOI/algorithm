package com.ssafy.java.algo.d1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2564 {
	static int R, C;
	static int N;
	static int total;
	static List<Integer> s1;
	static List<Integer> s2;
	static List<Integer> s3;
	static List<Integer> s4;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
	
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		N = Integer.parseInt(input.readLine());
		s1 = new ArrayList<>();
		s2 = new ArrayList<>();
		s3 = new ArrayList<>();
		s4 = new ArrayList<>();
		for(int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int d = Integer.parseInt(tokens.nextToken());
			int i = Integer.parseInt(tokens.nextToken());
			if(d == 1) {
				s1.add(i);
			}
			else if(d == 2) {
				s2.add(i);
			}
			else if(d == 3) {
				s3.add(i);
			}
			else {
				s4.add(i);
			}
		}
		tokens = new StringTokenizer(input.readLine());
		int startd = Integer.parseInt(tokens.nextToken());
		int starti = Integer.parseInt(tokens.nextToken());
		
		move(startd, starti);
		System.out.println(total);
	}
	
	static void move(int d, int i) {
		if(d == 1) {
			for (int store : s1) {
				total += Math.abs(store-i);
			}
			for (int store : s3) {
				total += store + i;
			}
			for (int store : s4) {
				total += store + C-i;
			}
			
			for (int store : s2) {
				total += Math.min(store + i + R, C-store + C-i + R);
			}
		}
		else if(d == 2) {
			for (int store : s2) {
				total += Math.abs(store-i);
			}
			for (int store : s3) {
				total += R-store + i;
			}
			for (int store : s4) {
				total += R-store + C-i;
			}
			
			for (int store : s1) {
				total += Math.min(store + i + R, C-store + C-i + R);
			}
		}
		else if(d == 3) {
			for (int store : s3) {
				total += Math.abs(store-i);
			}
			for (int store : s2) {
				total += R-i + store;
			}
			for (int store : s4) {
				total += store + i;
			}
			
			for (int store : s1) {
				total += Math.min(store + i + C, R-store + R-i + C);
			}
		}
		else {
			for (int store : s4) {
				total += Math.abs(store-i);
			}
			for (int store : s1) {
				total += C-store + i;
			}
			for (int store : s2) {
				total += C-store + R-i;
			}
			
			for (int store : s3) {
				total += Math.min(store + i + C, R-store + R-i + C);
			}
		}
	}
	static String src = "10 5\r\n" + 
			"3\r\n" + 
			"1 4\r\n" + 
			"3 2\r\n" + 
			"2 8\r\n" + 
			"2 3";
}
