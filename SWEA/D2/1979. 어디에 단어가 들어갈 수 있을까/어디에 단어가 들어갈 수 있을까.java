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
            int K = Integer.parseInt(st.nextToken());
            
            int[][] board = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            
            int answer = checkBoard(board, N, K) + checkBoard(turnBoard(board), N, K);
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
    
    static int checkBoard(int[][] board, int N, int K) {
        int answer = 0;
        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1)
                    count++;
                
                if(board[i][j] == 0 || j == N-1) {
                   if(count == K)
                       answer++;
                   count = 0;
                }
            }
        }
        
        return answer;
    }
    
    static int[][] turnBoard(int[][] board) {
        int[][] change = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board.length; j++)
                change[i][j] = board[j][i];
        
        return change;
    }
}