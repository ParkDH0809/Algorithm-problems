import java.util.*;
import java.io.*;

class Solution {
	static int[][] arr;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.append("#" + test_case + "\n");
			
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0;i < n; i++) {
				bw.append(method1(i));
				bw.append(method2(i));
				bw.append(method3(i));
				bw.append("\n");
			}
		}
        bw.close();
	}
	
	static String method1(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i][n]);
		}
		sb.append(" ");
		return sb.toString();
	}
	
	static String method2(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[arr.length - n - 1][i]);
		}
		sb.append(" ");
		return sb.toString();
	}
	
	static String method3(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i][arr.length - n - 1]);
		}
		sb.append(" ");
		return sb.toString();
	}
}