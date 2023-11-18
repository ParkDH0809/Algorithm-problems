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
			String s = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			
			if(s.length() < n) {
				n = s.length();
			}
			bw.append("#" + test_case + " " + method(s, n) + "\n");
		}
        bw.close();
	}
	
	static String method(String s, int count) {
		
		if(count == 0) {
			return s;
		}
		
		String answer = "0";
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				char[] ch = s.toCharArray();
				char tmp = ch[i];
				ch[i] = ch[j];
				ch[j] = tmp;
				
				String chStr = String.valueOf(ch);
				String str = method(chStr, count - 1);
				
				answer = Integer.parseInt(answer) > Integer.parseInt(str) ? answer : str; 
			}
		}
		
		return answer;
	}
}