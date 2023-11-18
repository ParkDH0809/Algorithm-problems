import java.util.*;
import java.io.*;

class Solution {
	static int[] arr;
	static int answer;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					method(arr[i] * arr[j]);
				}
			}
			if(answer == 0) {
				sb.append("#").append(test_case).append(" ").append("-1").append("\n");
			} else {
				sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			}
			
			
		}
        System.out.print(sb);
	}
	
	static void method(int n) {
		String s = String.valueOf(n);
		char c = '0';
		for(char ch : s.toCharArray()) {
			if(c > ch) {
				return;
			}
			c = ch;
		}
		
		answer = Math.max(answer, Integer.parseInt(s));
	}
}