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
			br.readLine();
            
            int[][] board = new int[100][100];
            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            bw.append("#" + test_case + " " +getMax(board));
            bw.newLine();
		}
        bw.flush();
	}
    
    static int getMax(int[][] board) {
        int max = 0;
        
        // 가로
        for(int i = 0; i < 100; i++) {
            int sum = 0;
            for(int j = 0; j < 100; j++) {
                sum += board[i][j];
            }
            max = Math.max(sum, max);
        }
        
        // 세로
        for(int i = 0; i < 100; i++) {
            int sum = 0;
            for(int j = 0; j < 100; j++) {
                sum += board[j][i];
            }
            max = Math.max(sum, max);
        }
        
        // 대각선
		int sum = 0;
        int sum2 = 0;
        for(int i = 0; i < 100; i++) {
            sum += board[i][i];
            sum2 += board[i][99-i];
        }
        
        return Math.max(max, Math.max(sum, sum2));
    }

}