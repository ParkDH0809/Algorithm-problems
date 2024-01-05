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
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                arr[i][0] = 1;
                for(int j = 1; j <= i; j++)
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
            
            bw.append("#" + test_case);
            bw.newLine();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j <= i; j++)
                    bw.append(arr[i][j] + " ");
                bw.newLine();
            }
		}
        bw.flush();
	}
}