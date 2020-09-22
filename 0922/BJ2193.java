package com.ssafy.java.algo.d0922;

import java.util.Scanner;

public class BJ2193 {

	static long[] memo;
	static long[] dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new long[N + 1];
		dp = new long[N+1];
		
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(getFibo());
//		System.out.print(getFibo(N));
	}

	static long getFibo() {
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[N];
	}
//	static long getFibo(int n) {
//		if (n > 1 && memo[n] == 0) {
//			memo[n] = getFibo(n - 1) + getFibo(n - 2);
//		}
//		return memo[n];
//	}
}
