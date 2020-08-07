package com.ssafy.algo.d0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N, K;
    static int[] map;
    static Queue<Integer> queue;
    static int[] dirs = {-1, +1, 2};
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        input = new BufferedReader(new StringReader(src));
        StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        map = new int[100000];
        
        queue = new LinkedList<>();
        
    }
    
    static void bfs() {
        int size;
        while(!queue.isEmpty()) {
            size = queue.size();
            while(--size >= 0) {
                Integer front = queue.poll();
                for(int d = 0; d < dirs.length; d++) {
                    
                }
            }
        }
    }
    static String src = "5 17";
}
