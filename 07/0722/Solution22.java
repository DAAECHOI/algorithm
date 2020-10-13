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

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] grid = new int[N][N];
			int s = sc.nextInt();
			int[][] ws = new int[s][3];
			for(int i = 0; i < ws.length; i++) {
				//ws.length==s ws[i].length == 0,1,2
				ws[i][0] = sc.nextInt();//행
				ws[i][1] = sc.nextInt();//열
				ws[i][2] = sc.nextInt();//방향
			}
			int cnt = s;
			for(int i = 0; i < ws.length; i++) {
				int x = ws[i][0];
				int y = ws[i][1];
				int dir = ws[i][2];
				if(grid[x][y] == 1) {
					cnt--;
					break;
				}
				else {
					if(dir == 1) {//상
						for(int j = 3; j >= 1; j--) {
							x -= j;
							if(x < 0 || grid[x][y] == 1) {
								cnt--;
								break;
							}
							if(j == 1)
								grid[x][y] = 1;
						}
					}
					else if(dir == 2){//하
						for(int j = 3; j >= 1; j--) {
							x += j;
							if(x >= N || grid[x][y] == 1) {
								cnt--;
								break;
							}
							if(j == 1)
								grid[x][y] = 1;
						}
					}
					else if(dir == 3) {//좌
						for(int j = 3; j >= 1; j--) {
							y -= j;
							if(y < 0 || grid[x][y] == 1) {
								cnt--;
								break;
							}
							if(j == 1)
								grid[x][y] = 1;
						}
					}
					else if(dir == 4) {//우
						for(int j = 3; j >= 1; j--) {
							y += j;
							if(y >= N || grid[x][y] == 1) {
								cnt--;
								break;
							}
							if(j == 1)
								grid[x][y] = 1;
						}
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
