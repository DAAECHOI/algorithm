import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

	static Stack<Integer> arr;
	static Stack<Integer> answer;
	static Stack<Integer> tmp;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input = new BufferedReader(new StringReader(src));
		String line = input.readLine();
		N = Integer.parseInt(line);
		arr = new Stack<Integer>();
		answer = new Stack<Integer>();
		tmp = new Stack<Integer>();
		
		StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");

        while (tokens.hasMoreTokens()) {
            arr.push(Integer.valueOf(tokens.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            tmp.push(arr.pop());
            int size = tmp.size();
            if(arr.isEmpty()) {
            	for(int t = 0; t < size; t++) {
            		answer.push(0);
            		tmp.pop();
            	}
            	break;
            }
	        if(tmp.peek() < arr.peek()) {
	        	if(arr.peek()-tmp.peek() < size)
	        		size = arr.peek()-tmp.peek();
	        	for(int t = 0; t < size; t++) {
	    	        if(tmp.peek() < arr.peek()) {
		        		answer.push(arr.size());
					    tmp.pop();
	    	        }
	    	        else
	    	        	break;
	        	}
	        }
        }
        for(int i = 0; i < N; i++)
        	System.out.print(answer.pop() + " ");
        System.out.println();
	}

	static String src = "5\r\n" + 
			"6 9 5 7 4";
}