package com.ssafy.java.day2.hw;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num;
		int[] digit = new int[10];
		
		while(true){
			num = sc.nextInt();
			if(num == 0){
				break;
			}
			digit[num / 10] += 1;
		}
		
		for(int i= 0; i < digit.length; i++) {
			if(digit[i] > 0) {
				System.out.println(i + " : " + digit[i] + "개");
			}
		}
	}

}
