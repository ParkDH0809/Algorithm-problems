import java.util.*;
import java.io.*;

class Solution {
	static int answer;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			
			char[][] arr = new char[100][100];
			for(int i = 0; i < 100; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			answer = 0;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = j + 1; k < 100; k++) {
						method(Arrays.copyOfRange(arr[i], j, k + 1));						
					}
				}
			}
			
			char[][] tmp = new char[100][100];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					tmp[i][j] = arr[j][i];
				}
			}
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = j + 1; k < 100; k++) {
						method(Arrays.copyOfRange(tmp[i], j, k + 1));						
					}
				}
			}
			
			bw.append("#" + test_case + " " + answer + "\n");
		}
        bw.close();
	}
	
	static void method(char[] input) {
		for (int i = 0; i < input.length / 2; i++) {
			if(input[i] != input[input.length - i - 1]) {
				return;
			}
		}
		answer = Math.max(answer, input.length);
	}
}