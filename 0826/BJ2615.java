package com.ssafy.java.algo.d0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2615 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int[][] omok;
	static List<Mapping> white;
	static List<Mapping> black;
	static int answer, answerR, answerC;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer tokens = null;
		
		omok = new int[19][19];
		white = new ArrayList<>();
		black = new ArrayList<>();
		for(int r = 0; r < 19; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 19; c++) {
				omok[r][c] = Integer.parseInt(tokens.nextToken());
				if(omok[r][c] == 1) {
					black.add(new Mapping(r,c));
				}
				else if(omok[r][c] == 2) {
					white.add(new Mapping(r,c));
				}
			}
		}
		
		checkBlack();
		checkWhite();
		
		System.out.println(answer);
		if(answer > 0) {
			System.out.println((answerR+1) + " " + (answerC+1));
		}
	}

	static void checkBlack() {
		for(Mapping b : black) {
			int count = 0;
			for(int i = b.r; isIn(i, b.c) && i <= b.r+5; i++) { //하
				if(omok[i][b.c] != 1) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(b.r-1, b.c) || (isIn(b.r-1, b.c) && omok[b.r-1][b.c] != 1)) {
					answerR = b.r;
					answerC = b.c;
					answer = 1;
					break;
				}
			}
			
			count = 0;
			for(int i = b.c; isIn(b.r, i) && i <= b.c+5; i++) { //우
				if(omok[b.r][i] != 1) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(b.r, b.c-1) || (isIn(b.r, b.c-1) && omok[b.r][b.c-1] != 1)) {
					answerR = b.r;
					answerC = b.c;
					answer = 1;
					break;
				}
			}
			
			count = 0;
			for(int i = 0; isIn(b.r+i, b.c+i) && i <= 5; i++) { //하대각
				if(omok[b.r+i][b.c+i] != 1) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(b.r-1, b.c-1) || (isIn(b.r-1, b.c-1) && omok[b.r-1][b.c-1] != 1)) {
					answerR = b.r;
					answerC = b.c;
					answer = 1;
					break;
				}
			}
			
			count = 0;
			for(int i = 0; isIn(b.r-i, b.c+i) && i <= 5; i++) { //상대각
				if(omok[b.r-i][b.c+i] != 1) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(b.r+1, b.c-1) || (isIn(b.r+1, b.c-1) && omok[b.r+1][b.c-1] != 1)) {
					answerR = b.r;
					answerC = b.c;
					answer = 1;
					break;
				}
			}
		}
	}
	
	static void checkWhite() {
		for(Mapping w : white) {
			int count = 0;
			for(int i = w.r; isIn(i, w.c) && i <= w.r+5; i++) { //하
				if(omok[i][w.c] != 2) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(w.r-1, w.c) || (isIn(w.r-1, w.c) && omok[w.r-1][w.c] != 2)) {
					answerR = w.r;
					answerC = w.c;
					answer = 2;
					break;
				}
			}
			
			count = 0;
			for(int i = w.c; isIn(w.r, i) && i <= w.c+5; i++) { //우
				if(omok[w.r][i] != 2) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(w.r, w.c-1) || (isIn(w.r, w.c-1) && omok[w.r][w.c-1] != 2)) {
					answerR = w.r;
					answerC = w.c;
					answer = 2;
					break;
				}
			}
			
			count = 0;
			for(int i = 0; isIn(w.r+i, w.c+i) && i <= 5; i++) { //하대각
				if(omok[w.r+i][w.c+i] != 2) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(w.r-1, w.c-1) || (isIn(w.r-1, w.c-1) && omok[w.r-1][w.c-1] != 2)) {
					answerR = w.r;
					answerC = w.c;
					answer = 2;
					break;
				}
			}
			
			count = 0;
			for(int i = 0; isIn(w.r-i, w.c+i) && i <= 5; i++) { //상대각
				if(omok[w.r-i][w.c+i] != 2) {
					break;
				}
				count++;
			}
			if(count == 5) {
				if(!isIn(w.r+1, w.c-1) || (isIn(w.r+1, w.c-1) && omok[w.r+1][w.c-1] != 2)) {
					answerR = w.r;
					answerC = w.c;
					answer = 2;
					break;
				}
			}
			
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < 19 && c >= 0 && c < 19;
	}
	
	static class Mapping{
		int r;
		int c;
		public Mapping() {}
		public Mapping(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static String src = "1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
}
