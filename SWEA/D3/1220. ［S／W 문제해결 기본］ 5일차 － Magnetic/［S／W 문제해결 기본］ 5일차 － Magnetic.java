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
                    board[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;
            for(int i = 0; i < 100; i++) {
                answer += getCount(board[i]);
            }
            
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
    
    static int getCount(int[] arr) {
        int count = 0;
        boolean check = false;
        for(int i = 0; i < 100; i++) {
            if(arr[i] == 1) {
                check = true;
            }
            
            if(arr[i] == 2 && check) {
                count++;
                check = false;
            }
        }
        
        return count;
    }
}