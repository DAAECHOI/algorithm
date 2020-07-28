package com.ssafy.java.algo;

import java.util.Scanner;

public class Algo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int cnt = 0, index = 1;
			//index : 1부터 N까지 value, cnt : 달팽이처럼 돌기위해 반복문에 들어갈 count
			int r = 0, c = -1;
			
			for(int ri = 0; ri < N-cnt; ri++) {
				c++;
				snail[r][c] = index++;
			}
			cnt++;
			while(cnt <= N){
				for(int d = 0; d < N-cnt; d++) {
					r++;
					snail[r][c] = index++;
				}
				for(int l = 0; l < N-cnt; l++) {
					c--;
					snail[r][c] = index++;
				}
				cnt++;
				for(int u = 0; u < N-cnt; u++) {
					r--;
					snail[r][c] = index++;
				}
				for(int ri = 0; ri < N-cnt; ri++) {
					c++;
					snail[r][c] = index++;
				}
				cnt++;
			}
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
