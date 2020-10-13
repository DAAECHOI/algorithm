package com.ssafy.java.algo.d0928;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA5607 {
	static int T, N, R;
	static final int m = 1234567891;
	static long[] fac;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		fac = new long[1000000 + 1];
		fac[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			fac[i] = fac[i - 1] * i % m;
		}
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			R = sc.nextInt();

			long down = (fac[R]) * (fac[N - R]) % m;
			long up = fac[N];
			down = pow(down, m - 2);
			System.out.println("#" + t + " " + (up * down % m));
		}
	}

	static long pow(long num, int p) {
		if (p == 0)
			return 1;
		else if (p == 1)
			return num;
		if (p % 2 == 0) {
			long daq = pow(num, p / 2);
			return daq * daq % m;
		} else {
			long daq = pow(num, p - 1);
			return daq * num % m;
		}
	}
}
