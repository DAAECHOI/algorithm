package com.ssafy.java.day1.hw;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int n = w + 100 - h;
		System.out.println("비만수치는 " + n + "입니다.");
		
		if(n > 0)
			System.out.println("당신은 비만이군요.");
	}

}
