package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author DAAECHOI
 * @date 2020. 8. 17
 * @see
 * @mem 16864KB
 * @time 180ms
 * @caution
 * [고려사항] 문제 접근 방법을 빠르게 파악할 필요가 있음
 * [입력사항] 
 * [출력사항]
 */
public class BJ1018 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static char[][] board;
	static char[][] tmpBoard;
	static int R, C;
	static int dColor, ptCnt;
	static int MIN;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		board = new char[R][C];
		tmpBoard = new char[R][C];
		for(int r = 0; r < R; r++) {
			String line = input.readLine();
			for(int c = 0; c < C; c++) {
				board[r][c] = line.charAt(c);
				tmpBoard[r][c] = line.charAt(c);
			}
		}
		
		MIN = Integer.MAX_VALUE;
		for(int i = 0; i <= R-8; i++) {
			for(int j = 0; j <= C-8; j++) {
				MIN = Math.min(MIN,Wcheck(i, j));
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						board[r][c] = tmpBoard[r][c];
					}
				}
				
				MIN = Math.min(MIN,Bcheck(i, j));
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						board[r][c] = tmpBoard[r][c];
					}
				}
			
			}
		}
		
		System.out.println(MIN);
	}

	static int Wcheck(int i, int j) { //'W'로 시작할 때
		int ptCnt = 0;
		int idx = 0;
		for(int r = i; r < i+8; r++) {
			int idx2 = idx;
			for(int c = j; c < j+8; c++) {
				if(idx2%2 == 0 && board[r][c] != 'W') {
					board[r][c] = 'W';
					ptCnt++;
				}
				else if(idx2%2 == 1 && board[r][c] != 'B') {
					board[r][c] = 'B';
					ptCnt++;
				}
				idx2++;
			}
			idx++;
		}
		return ptCnt;
	}
	
	static int Bcheck(int i, int j) { //'B'로 시작할 때
		int ptCnt = 0;
		int idx = 0;
		for(int r = i; r < i+8; r++) {
			int idx2 = idx;
			for(int c = j; c < j+8; c++) {
				if(idx2%2 == 0 && board[r][c] != 'B') {
					board[r][c] = 'B';
					ptCnt++;
				}
				else if(idx2%2 == 1 && board[r][c] != 'W') {
					board[r][c] = 'W';
					ptCnt++;
				}
				idx2++;
			}
			idx++;
		}
		return ptCnt;
	}
	
	static String src = "8 8\r\n" + 
			"WWBBBBBB\r\n" + 
			"WBBBBBBB\r\n" + 
			"BBBBBBBB\r\n" + 
			"BBBBBBBB\r\n" + 
			"BBBBBBBB\r\n" + 
			"BBBBBBBB\r\n" + 
			"BBBBBBBB\r\n" + 
			"BBBBBBBB";
}
