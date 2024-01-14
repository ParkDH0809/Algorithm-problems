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
            int N = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken())*2 + 1;
            
            if(N % range == 0)
                bw.append("#" + test_case + " " + N/range + "\n");
            else
                bw.append("#" + test_case + " " + (N/range + 1) + "\n");
		}
        bw.flush();
	}
}