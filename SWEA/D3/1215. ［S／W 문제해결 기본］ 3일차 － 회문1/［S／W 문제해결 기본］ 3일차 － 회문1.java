import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8]; 
			for(int i = 0; i < 8; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			int answer = 0;
			answer += method(arr, n);
			
			char[][] tmp = new char[8][8];
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					tmp[i][j] = arr[j][i];
				}
			}
			answer += method(tmp, n);
			bw.append("#" + test_case + " "+ answer + "\n");
		}
        bw.close();
	}
	
	
	static int method(char[][] arr, int n) {
		int answer = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8 - n + 1; j++) {
				if(palindrome(Arrays.copyOfRange(arr[i], j, j + n))) {
					answer++;
				}
			}
		}
		return answer;
	}
	
	static boolean palindrome(char[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			if(arr[i] != arr[arr.length - i - 1]) {
				return false;				
			}
		}
		return true;
	}
}