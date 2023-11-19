import java.util.*;
import java.io.*;

class Solution {
	static int N, answer;
	static int[] board;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int answer = method(1, N, M);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
	
	static int method(int sum, int N, int M) {
		if(M == 0) {
			return sum;
		}
		return method(sum * N, N, M - 1);
	}
}