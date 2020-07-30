package com.ssafy.java.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

	static Stack<Integer> arr;
	static int[] answer;
	static int[] tmp;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input = new BufferedReader(new StringReader(src));
		String line = input.readLine();
		N = Integer.parseInt(line);
		arr = new Stack<Integer>();
		answer = new int[N];
		tmp = new int[N];
		
		StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");

        while (tokens.hasMoreTokens()) {
            arr.push(Integer.valueOf(tokens.nextToken()));
        }

        int answerIdx = 0;
        for(int i = 0; i < N; i++) {
            tmp[i] = arr.pop();
            int tmpIdx = i+1;
            if(arr.isEmpty()) {
            	for(int t = tmpIdx; t <= answerIdx; t--) {
            		answer[answerIdx] = 0;
            		answerIdx++;
            	}
            	break;
            }
	        if(tmp[i] < arr.peek()) {
	        	if(arr.peek()-tmp[i] < tmpIdx)
	        		tmpIdx = arr.peek()-tmp[i];
	        	for(int t = tmpIdx; t <= answerIdx; t--) {
	    	        if(tmp[t] < arr.peek()) {
		        		answer[answerIdx] = arr.size();
		        		answerIdx++;
	    	        }
	    	        else
	    	        	break;
	        	}
	        }
        }
        for(int i = N-1; i >= 0; i--)
        	System.out.print(answer[i] + " ");
        
	}

	static String src = "5\r\n" + 
			"6 9 5 7 4";
}
