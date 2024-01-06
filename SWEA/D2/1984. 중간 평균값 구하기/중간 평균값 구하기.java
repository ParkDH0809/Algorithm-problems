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
			int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < 10; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(arr);
            
            int sum = 0;
            for(int i = 1; i < 9; i++)
                sum += arr[i];
            
            bw.append("#" + test_case + " " + (int)Math.round(sum/8.0) + "\n");
		}
        bw.flush();
	}
}