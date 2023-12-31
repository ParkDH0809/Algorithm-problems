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
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            
            int[][] turn90 = turn(arr, N);
            int[][] turn180 = turn(turn90, N);
            int[][] turn270 = turn(turn180, N);
            
            bw.append("#" + test_case);
            bw.newLine();
            for(int i = 0; i < N; i++) {
                bw.append(getLine(turn90, i));
                bw.append(getLine(turn180, i));
                bw.append(getLine(turn270, i));
                bw.newLine();
            }
		}
        bw.flush();
	} 
    
    static int[][] turn(int[][] arr, int N) {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) 
            for(int j = 0; j < N; j++)
                result[i][N - j - 1] = arr[j][i];
                
        return result;
    }
    
    static String getLine(int[][] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < arr.length; i++) 
        	sb.append(arr[n][i]);
        sb.append(" ");
        return sb.toString();
    }
}