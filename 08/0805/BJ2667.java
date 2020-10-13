package com.ssafy.algo.d0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2667 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
      
    static int N;
    static int total;
    static int[] hCnt;
    static int hIdx;
    static int cnt;
    static int[][] houses;
    static boolean[][] visited;
    static int[][] dirs = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    static Queue<Houses> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        input = new BufferedReader(new StringReader(src));
        
        StringTokenizer tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
              
        houses = new int[N][N];
        visited = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            String line = input.readLine();
            for(int c = 0; c < N; c++) {
                houses[r][c] = line.charAt(c) - '0';
            }
        }
        
        hCnt = new int[N*N];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(houses[r][c] == 1 && !visited[r][c]) {
                    bfs(new Houses(r,c));
                    hCnt[total++] = cnt;
                }
            }
        }
        
        output.append(total+"\n");
        Arrays.sort(hCnt);
        for(int i = hCnt.length-total; i < hCnt.length; i++)
            output.append(hCnt[i]+"\n");
        System.out.println(output);
    }
    
    static void bfs(Houses h) {
        int size;
        cnt = 0;
        queue.offer(h);
        visited[h.row][h.col] = true;
        
        while(!queue.isEmpty()) {
            size = queue.size();
            while(--size >= 0) {
                Houses front = queue.poll();
                
                for(int d = 0; d < dirs.length; d++) {
                    int nr = front.row + dirs[d][0];
                    int nc = front.col + dirs[d][1];
                    if(isIn(nr, nc) && houses[nr][nc] == 1 &&!visited[nr][nc]) {
                        queue.offer(new Houses(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
                cnt++;
            }
        }
    }
    
    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
    
    static class Houses{
        int row;
        int col;
        
        public Houses(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    static String src = "7\r\n" + 
            "0110100\r\n" + 
            "0110101\r\n" + 
            "1110101\r\n" + 
            "0000111\r\n" + 
            "0100000\r\n" + 
            "0111110\r\n" + 
            "0111000";
}
