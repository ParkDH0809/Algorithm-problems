import java.util.*;
import java.io.*;

class Solution {
	static int N, answer;
	static int[] board;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			String search = br.readLine();
			String input = br.readLine();
			
			int answer = 0;
			for(int i = 0; i < input.length() - search.length() + 1; i++) {
				if(input.substring(i, i + search.length()).equals(search)) {
					answer++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
}