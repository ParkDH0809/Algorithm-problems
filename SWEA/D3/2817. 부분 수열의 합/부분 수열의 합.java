import java.util.*;
import java.io.*;

class Solution {
	static int N, K, answer;
	static int[] arr;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = 0;
			method(0, 0);
			
			bw.append("#" + test_case + " "+ answer + "\n");
		}
        bw.close();
	}
	
	static void method(int cor, int sum) {
		if(sum == K) {
			answer++;
			return;
		}
		
		if(cor == N) {
			return;
		}
		
		method(cor + 1, sum + arr[cor]);
		method(cor + 1, sum);
	}
}