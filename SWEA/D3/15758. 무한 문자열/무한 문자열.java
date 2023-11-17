import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			String answer;
			if(s1.length() > s2.length()) {
				answer = method(s1, s2);
			} else {
				answer = method(s2, s1);
			}
			
			bw.append("#" + test_case + " "+ answer + "\n");
		}
        bw.close();
	}
	
	static String method(String max, String min) {
		max = max + max;
		char[] maxArr = max.toCharArray();
		char[] minArr = min.toCharArray();
		int cor = 0;
		while(cor < maxArr.length) {
			
			for(int i = cor; i < cor + minArr.length; i++) {
				if(maxArr.length <= i) {
					break;
				}
				
				if(maxArr[i] != minArr[i - cor])
					return "no";
			}
			cor += min.length();
		}
		return "yes";
	}
}