import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            while(N-- > 0) {
                int current = Integer.parseInt(br.readLine());
                if(current != 0) {
                    stack.push(current);
                } else {
                    stack.pop();
                }
            }
            
            int answer = 0;
            for(int i : stack) {
                answer += i;
            }
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
}