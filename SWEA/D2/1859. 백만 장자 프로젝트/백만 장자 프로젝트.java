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
			int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            int max = arr[N-1];
            int point = N-1;
            long answer = 0;
            for(int i = N-2; i >= 0; i--) {
                if(arr[i] > max) {
                    for(int j = point; j > i; j--) {
						answer += max - arr[j];
                    }
                    max = arr[i];
                    point = i;
                }
            }
            
            for(int i = 0; i < point; i++) 
                answer += max - arr[i];
            
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
}