import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			sb.append("#").append(test_case).append(" ").append(method(N, s)).append("\n");
		}
        System.out.print(sb);
	}
	
	static String method(int N, String s) {
		StringBuilder sb = new StringBuilder(s);
		
		while(true) {
			boolean check = true;
			for(int i = 0; i < sb.length() - 1; i++) {
				if(sb.charAt(i) == sb.charAt(i + 1)) {
					sb.delete(i, i + 2);
					check = false;
				}
			}
			
			if(check) {
				break;
			}
		}
		
		return sb.toString();
	}
}