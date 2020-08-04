package com.ssafy.java.algo.d0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1863 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N, M;
	static int[] rank;//각 노드의 등급
	static int[] repres;//각 원소의 대표자
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer tokens = null;
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
			
		makeSet();
		for(int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			//a, b
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
				
			union(findSet(a),findSet(b));
		}
		
		int answerCnt = 0;
	    for(int i = 1; i < repres.length; i++) {
	    	if(i == repres[i])
	    		answerCnt++;
	    }
		System.out.println(answerCnt);
	}
	
	//서로소인 집합으로 만들기
	static void makeSet() {
		repres = new int[N+1];//value가 0이면 대표자
		rank = new int[N+1];
		for(int i = 1; i < repres.length; i++) {
			repres[i] = i;
			rank[i] = 1;
		}
	}
	
	static int findSet(int v) {
		if(repres[v] == v) { //내가 대표자
			return v;
		}
		else {
			//path compression
			//탐색하면서 저장해두기
			return repres[v] = findSet(repres[v]); //내 대표자를 기준으로 다시 탐색
		}
	}
	
	static void union(int a, int b) {
		a = findSet(a); //a의 대표자 찾기
		b = findSet(b); //b의 대표자 찾기
		if(a != b) { //같은 집합이 아니라면
			if(rank[a] == rank[b]) {
				rank[a]++;
			}
			if(rank[a] > rank[b]) {
				repres[b] = a; //b의 등급이 작다면 b의 대표자를 a의 대표자로 변경
			}
			else {
				repres[a] = b; //a의 대표자를 b의 대표자로 변경
			}
		}
	}
	static String src = "10 7\r\n" + 
			"1 2\r\n" + 
			"3 5\r\n" + 
			"1 6\r\n" + 
			"3 7\r\n" + 
			"1 8\r\n" + 
			"1 9\r\n" + 
			"10 4";
}
