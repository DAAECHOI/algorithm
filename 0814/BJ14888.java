package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14888 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static Queue<Integer> nums;
	static Queue<Integer> numsCopy;
	static int[] op = new int[4];
	static char[] charOp;
	static int opCnt;
	static int MIN;
	static int MAX;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer tokens = null;
		
		int N = Integer.parseInt(input.readLine());
		nums = new LinkedList<>();
		numsCopy = new LinkedList<>();
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int n = 0; n < N; n++) {
			nums.offer(Integer.parseInt(tokens.nextToken()));
		}
		numsCopy.addAll(nums);
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(tokens.nextToken());
			opCnt += op[i];
		}
		charOp = new char[opCnt];
		
		int index = 0;
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				if(i == 0) {
					for(int j = 0; j < op[i]; j++) {
						charOp[index++] = '+';
					}
				}
				else if(i == 1) {
					for(int j = 0; j < op[i]; j++) {
						charOp[index++] = '-';
					}
				}
				else if(i == 2) {
					for(int j = 0; j < op[i]; j++) {
						charOp[index++] = '*';
					}
				}
				else if(i == 3) {
					for(int j = 0; j < op[i]; j++) {
						charOp[index++] = '/';
					}
				}
			}
		}
		
		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;
		makePerm(opCnt, new boolean[opCnt], new char[opCnt]);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	static void makePerm(int r, boolean[] visited, char[] tmp) {
		if(r == 0) {
			System.out.println(Arrays.toString(tmp));
			int answer = nums.poll();
			for(int i = 0; i < tmp.length; i++) {
				if(tmp[i] == '+') {
					answer = answer + nums.poll();
				}
				else if(tmp[i] == '-') {
					answer = answer - nums.poll();
				}
				else if(tmp[i] == '*') {
					answer = answer * nums.poll();
				}
				else if(tmp[i] == '/') {
					if(answer < 0) {
						answer = (Math.abs(answer) / nums.poll()) * -1;
					}
					else {
						answer = answer / nums.poll();
					}
				}
			}
			MIN = Math.min(MIN, answer);
			MAX = Math.max(MAX, answer);
			nums.addAll(numsCopy);
			return;
		}
		for(int i = 0; i < charOp.length; i++) {
			if(!visited[i]) {
				tmp[r-1] = charOp[i];
				visited[i] = true;
				makePerm(r-1, visited, tmp);
				visited[i] = false;
			}
		}
	}
	
	static String src = "6\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"2 1 1 1";
}
