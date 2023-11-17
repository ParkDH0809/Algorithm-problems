import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            br.readLine();
            
			int[][] arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가로, 세로
			int answer = Integer.MIN_VALUE;
			int sum = 0;
			int sum2 = 0;
			for(int i = 0; i < 100; i++) {
                sum = sum2 = 0;
				for(int j = 0; j < 100; j++) {
					sum += arr[i][j];
					sum2 += arr[j][i];
				}
				answer = Math.max(sum,  answer);
				answer = Math.max(sum2,  answer);
			}
			
			//대각선
			sum = 0;
			sum2 = 0;
			for(int i = 0; i < 100; i++) {
				sum += arr[i][i];
				sum2 += arr[99 - i][i];
			}
			answer = Math.max(sum,  answer);
			answer = Math.max(sum2,  answer);
			
			bw.append("#" + test_case + " "+ answer + "\n");
		}
        bw.close();
	}
}