import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
            
            int[] score = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                score[Integer.parseInt(st.nextToken())]++;
            }
            
            int answer = 0;
            int max = 0;
            for(int i = 0; i <= 100; i++) {
                if(score[i] >= max) {
                    answer = i;
                    max = score[i];
                }
            }
            
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
}