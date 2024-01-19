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
			int n = Integer.parseInt(br.readLine());
            char[][] board = new char[8][8];
            for(int i = 0; i < 8; i++) {
                board[i] = br.readLine().toCharArray();
            }
            
            int answer = 0;
            answer += check(board, n);
            board = turnBoard(board);
            answer += check(board, n);
            
            bw.append("#" + test_case + " " + answer);
            bw.newLine();
		}
        bw.flush();
	}
    
    static int check(char[][] board, int n) {
        int count =0;
        for(int i=0; i < 8; i++) {
            for(int j=0; j <= 8-n; j++) {
                if(isPalindrome(Arrays.copyOfRange(board[i], j, j+n))) {
                    count++;
                }
            }
        }
        return count;       
    }
    
    static boolean isPalindrome(char[] arr) {
        for(int i =0 ; i < arr.length / 2; i++) {
            if(arr[i] != arr[arr.length - (i+1)]) {
                return false;
            }
        }
        return true;
    }
    
    static char[][] turnBoard(char[][] board) {
        char[][] changed = new char[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                changed[i][j] = board[j][8-(i+1)];
            }
        }
        return changed;
    }
}