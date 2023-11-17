import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] answer = new int[arr.length];
			
			for(int i = 0; i < arr.length; i++) {
				answer[i] = n / arr[i];  
				n -= arr[i] * answer[i];
			}
			
			bw.append("#" + test_case + "\n"); 
			for(int i : answer) {
				bw.append(i + " ");
			}
			bw.append("\n");
		}
        bw.close();
	}
}