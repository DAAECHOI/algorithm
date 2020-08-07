package com.ssafy;

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
    static boolean[] visited;
    static int[] dirs = {-1, +1, 2};
    static Queue<Integer> queue;
    
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        map = new int[100001];
        visited = new boolean[100001];
        
        queue = new LinkedList<>();
        bfs(N);
    }
    
    static void bfs(int start) {
    	 int size, cnt = 0;
    	 boolean found = false;
    	 
         queue.offer(start);
         visited[start] = true;
         
         while(!queue.isEmpty() && !found) {
             size = queue.size();
             while(--size >= 0) {
                 Integer front = queue.poll();
                 if(front == K) {
                	 System.out.print(cnt);
                	 found = true;
                	 break;
                 }
                 int nf = front;
                 for(int d = 0; d < dirs.length; d++) {
                	 if(d == 0)
                		 nf = front + dirs[d];
                	 else if(d == 1)
                		 nf = front + dirs[d];
                	 else if(d == 2)
                		 nf = front * dirs[d];
                	 
                     if(nf <= 100000 && nf >= 0 && !visited[nf]) {
                         queue.offer(nf);
                         visited[nf] = true;
                     }
                 }
             }
             cnt++;
         }
    }
    
    static String src = "5 17";
}
