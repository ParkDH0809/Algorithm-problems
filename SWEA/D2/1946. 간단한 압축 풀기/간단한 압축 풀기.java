import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			bw.append("#" + test_case + "\n");
			int N = Integer.parseInt(br.readLine());
			
			int cor = 1;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < n; j++) {
					bw.append(s);
					if(cor % 10 == 0) {
						bw.append("\n");
					}
					cor++;
				}
			}
			bw.append("\n");
		}
        bw.close();
	}
}