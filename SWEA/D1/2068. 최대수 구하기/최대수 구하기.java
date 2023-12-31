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
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int max = 0;
            for(int i = 0; i < 10; i++) {
                int current = Integer.parseInt(st.nextToken());
                if(current > max)
                    max = current;
            }
            
            bw.append("#" + test_case + " " + max);
            bw.newLine();
		}
        bw.flush();
	}
}