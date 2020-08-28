package com.ssafy.java.algo.d0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ15961 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, d, k, c;
	static int[] belt;
	static int[] scase;
	static boolean coupon;
	static int kcount;
	static int MAX;
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		d = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		
		belt = new int[N+k];
		scase = new int[d+1];
		
		for(int n = 0; n < N; n++) {
			belt[n] = Integer.parseInt(input.readLine());
		}
		for(int i = 0; i < k; i++) {
			belt[N+i] = belt[i];
		}
		
		MAX = Integer.MIN_VALUE;
		scase[belt[0]]++;
		kcount = 1;
		int cur = 1;
		for(int i = 0; i < N+k-1; i++) {
			if(scase[belt[i+1]] == 0) {
				kcount++;
			}
			scase[belt[i+1]]++;
			cur++;
			if(cur == k) {
				if(scase[c] == 0) {
					kcount++;
				}
				MAX = Math.max(MAX, kcount);
				if(scase[c] == 0) {
					kcount--;
				}
				scase[belt[i+1-cur+1]]--;
				if(scase[belt[i+1-cur+1]] == 0) {
					kcount--;
				}
				cur--;
			}
		}
		
		System.out.println(MAX);
		
	}
}