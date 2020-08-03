package com.ssafy.java.algo.d0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEAspotMart {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N, T, M;
	static int[] snacks;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			snacks = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for(int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(tokens.nextToken());
			}
			answer = -1;
			makeCombination(2, 0, new int[2]);
	        output.append("#").append(t).append(" " ).append(answer).append("\n");
        }
        System.out.print(output);
	}
	
	static void makeCombination(int r, int start, int[] temp) {
        if (r == 0) {
            System.out.println(Arrays.toString(temp));
            if(temp[0] + temp[1] > M)
            	return;
            else if(temp[0] + temp[1] <= M) {
            	if(answer < temp[0] + temp[1])
            		answer = temp[0] + temp[1];
            }
            return;
        }
        for (int i = start; i < snacks.length; i++) {
            temp[r - 1] = snacks[i];
            makeCombination(r - 1, i + 1, temp);
        }
    }
    
	static String src = "4\r\n" + 
			"3 45\r\n" + 
			"20 20 20\r\n" + 
			"6 10\r\n" + 
			"1 2 5 8 9 11\r\n" + 
			"4 100\r\n" + 
			"80 80 60 60\r\n" + 
			"4 20\r\n" + 
			"10 5 10 16";
}
