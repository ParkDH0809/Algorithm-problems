import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		int[] arr = {2, 3, 5, 7, 11};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] answer = new int[arr.length];
			for(int i = 0; i < arr.length; i++) {
				while(n % arr[i] == 0) {
					n = n / arr[i];
					answer[i]++;
				}
			}
			
			bw.append("#" + test_case);
			for(int i : answer) {
				bw.append(" " + i);
			}
			bw.append("\n");
		}
        bw.close();
	}
}