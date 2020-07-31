package com.ssafy.algo.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Stack;

public class Calc {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N,M;
    static char[] inpArr;
    static Stack<Integer> calc;
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        input = new BufferedReader(new StringReader(src));

        for(int t = 1; t <= 10; t++) {
            N = Integer.parseInt(input.readLine());
            inpArr = new char[N];
            calc = new Stack<Integer>();
            int fir,sec;
            int mCnt = 0;
            int answer = 0;
            
            String line = input.readLine();
            inpArr = line.toCharArray();
            
            for(int i = 0; i < N; i++) {
                if(inpArr[i] == '*')
                    mCnt++;
                else if(inpArr[i] == '+') {
                    int idx = mCnt;
                    for(int j = 0; j < idx; j++) {
                        fir = calc.pop();
                        sec = calc.pop();
                        calc.push(fir * sec);
                        mCnt--;
                    }
                }
                else
                    calc.push(inpArr[i] - '0');
            }

            int idx = mCnt;
            for(int i = 0; i < idx; i++) {
                fir = calc.pop();
                sec = calc.pop();
                calc.push(fir * sec);
                mCnt--;
            }
            
            while(!calc.isEmpty())
                answer += calc.pop();
            
            System.out.println("#" + t + " " + answer);
        }
    }
    static String src = "101\r\n" + 
            "9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3\r\n" + 
            "79\r\n" + 
            "4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1\r\n" + 
            "";
}
