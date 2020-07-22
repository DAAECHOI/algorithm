package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
	static int T;// 전체 TC
	static int N;// 맵의 크기
	static int S;// 소금쟁이 수
	static int [][] lake;
	static int [][] strider;
	static int answer;
	
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("Waterstrider2.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			lake = new int[N][N];
			S = sc.nextInt() + 1;
			strider = new int[S][3];
			
			for(int i = 1; i < S; i++) {
				strider[i][0] = sc.nextInt();
				strider[i][1] = sc.nextInt();
				strider[i][2] = sc.nextInt();
			}
			
			answer = S;
			for(int i=1; i<S; i++) {
				int row = strider[i][0];
				int col = strider[i][1];
				int dir = strider[i][2];
				
				if(lake[row][col]==1) {
					answer--;
					break;
				}else {
					if(dir==4) {//우
						for(int h=3;h>=1; h--) {
							col +=h;
							if(col < N) {
								if(lake[row][col]==1) {
									answer--;
									break;
								}
							}
							else {
								answer--;
								break;
							}
							if(h == 1){
								lake[row][col]=1;
							}
						}
					}
					if(dir==3) {//좌
						for(int h=3;h>=1; h--) {
							col -=h;
							if(col >= 0) {
								if(lake[row][col]==1) {
									answer--;
									break;
								}
							}
							else {
								answer--;
								break;
							}
							if(h == 1){
								lake[row][col]=1;
							}
						}
					}
					if(dir==2) {//하
						for(int v=3; v>=1; v--) {
							row +=v;
							if(row < N) {
								if(lake[row][col]==1) {
									answer--;
									break;
								}
							}
							else {
								answer--;
								break;
							}
							if(v == 1){
								lake[row][col]=1;
							}
						}
					}
					if(dir==1) {//상
						for(int v=3; v>=1; v--) {
							row -=v;
							if(row >= 0) {
								if(lake[row][col]==1) {
									answer--;
									break;
								}
							}
							else {
								answer--;
								break;
							}
							if(v == 1){
								lake[row][col]=1;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+(answer-1));
		}
	}
}
