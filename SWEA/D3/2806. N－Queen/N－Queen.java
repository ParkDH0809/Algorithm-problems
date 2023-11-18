import java.util.*;
import java.io.*;

class Solution {
	static int N, answer;
	static int[] board;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			answer = 0;
			board = new int[N];
			method(0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
	
	static void method(int count) {
		if(count == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			boolean check = true;
			for(int j = 0; j < count; j++) {
				if(board[j] == i || board[j] + count - j == i || board[j] - count + j == i) {
					check = false;
					break;
				}
			}
			
			if(check) {
				board[count] = i;
				method(count + 1);
			}
		}
	}
}