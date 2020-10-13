package com.ssafy.java.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2309 {

	static int[] dw = new int[9];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < dw.length; i++) {
			dw[i] = sc.nextInt();
		}
		makeComb(7, 0, new int[7]);
	}
	static void makeComb(int r, int start, int[] temp) {
		if (r == 0) {
            int sum = 0;
            for(int j = 0 ; j < temp.length; j++) {
            	sum += temp[j];
            }
            if(sum == 100) {
            	Arrays.sort(temp);
            	for(int i = 0; i < temp.length; i++)
            		System.out.println(temp[i]);
            	return;
            }
            return;
        }
        for (int i = start; i < dw.length; i++) {
            temp[r - 1] = dw[i];
            makeComb(r - 1, i + 1, temp);
        }
    }

}
