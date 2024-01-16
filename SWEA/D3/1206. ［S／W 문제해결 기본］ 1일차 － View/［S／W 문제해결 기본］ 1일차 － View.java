import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            for(int i = 2; i < N-2; i++) {
                int max = Math.max(Math.max(arr[i-1], arr[i-2]), Math.max(arr[i+1], arr[i+2]));
                if(arr[i] > max)
                	answer += arr[i] - max;
            }
            
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
}