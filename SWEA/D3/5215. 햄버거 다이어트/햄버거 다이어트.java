import java.util.*;
import java.io.*;

class Solution {
	static int limit;
	static int[][] arr;
	static int N;
	static int answer;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
            answer = 0;
			method(0, 0, 0);
			bw.append("#" + test_case + " " + answer + "\n");
		}
        bw.close();
	}
	
	static void method(int current,  int score, int cal) {
		if(cal > limit) {
			return;
		}
		
		if(current == N) {
			if(score > answer) {
				answer = score;
			}
			return;
		}
		
		method(current + 1, score + arr[current][0], cal + arr[current][1]);
		method(current + 1, score, cal);
	}
}