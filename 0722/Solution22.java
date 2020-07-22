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
			// 소금쟁이 수 - 인덱스 조정
			S = sc.nextInt() + 1;
			strider = new int[S][3];
			for(int i = 1; i < S; i++) {// 0번 인덱스는 조절을 위해 버림
				strider[i][0] = sc.nextInt();// 행 위치
				strider[i][1] = sc.nextInt();// 열 위치
				strider[i][2] = sc.nextInt();// 방향(상:1, 하:2, 좌:3, 우:4)
			}
			
			answer = 0;// 정답 초기화!!
			outer: for(int i=1; i<S; i++) {
				int row = strider[i][0];
				int col = strider[i][1];
				int dir = strider[i][2];
				// 최초 위치에서 발견되면 땡!!!
				if(lake[row][col]==1) {
					break outer;
				}else {
					// 방향에 맞춰서 jump
					if(dir==4) {//우
						for(int h=3;h>=1; h--) {
							col +=h;
							if(col < N) {
								if(lake[row][col]==1) {
									break outer;
								}
								if(h == 1) {
									lake[row][col]=1;
								}
							}
							else {
								break outer;
							}
						}
						System.out.println(row + " " + col);
						answer++;
					}
					if(dir==3) {//좌
						for(int h=3;h>=1; h--) {
							col -=h;
							if(col >= 0) {
								if(lake[row][col]==1) {
									break outer;
								}
								if(h == 1) {
									lake[row][col]=1;
								}
							}
							else {
								break outer;
							}
						}
						System.out.println(row + " " + col);
						answer++;
					}
					if(dir==2) {//하
						for(int v=3; v>=1; v--) {
							row +=v;
							if(row < N) {
								if(lake[row][col]==1) {
									break outer;
								}
								if(v == 1) {
									lake[row][col]=1;
								}
							}
							else {
								break outer;
							}
						}
						System.out.println(row + " " + col);
						answer++;
					}
					if(dir==1) {//상
						for(int v=3; v>=1; v--) {
							row -=v;
							if(row >= 0) {
								if(lake[row][col]==1) {
									break outer;
								}
								if(v == 1) {
									lake[row][col]=1;
								}
							}
							else {
								break outer;
							}
						}
						System.out.println(row + " " + col);
						answer++;
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
		
	}
}
