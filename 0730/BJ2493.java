import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

	static Stack<Integer> Tower;
	static Stack<Integer> tIdx;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		Tower = new Stack<Integer>();
		tIdx = new Stack<Integer>();
		
		StringTokenizer tokens = new StringTokenizer(input.readLine());

        for(int i = 1; i <= N; i++) {
        	int newT = Integer.valueOf(tokens.nextToken());
            while(!Tower.isEmpty()) {
            	if(newT > Tower.peek()) {
		        	Tower.pop();
		        	tIdx.pop();
            	}
            	else {
            		break;
            	}
	        }
            if(Tower.isEmpty())
            	output.append("0 ");
            else
            	output.append(tIdx.peek() + " ");
            Tower.push(newT);
            tIdx.push(i);
        }
        System.out.println(output);
	}

	static String src = "";
}
