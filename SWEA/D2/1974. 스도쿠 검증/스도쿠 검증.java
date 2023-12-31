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
            int[][] board = new int[9][9];
            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 9; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            
            bw.append("#" + test_case + " " + getAnswer(board));
            bw.newLine();
		}
        bw.flush();
	}
    
    static int getAnswer(int[][] board) {
        //가로 확인
        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(!check[board[i][j]]) {
                    check[board[i][j]] = true;
                } else {
                    return 0;
                }
            }
        }
        
        //세로 확인
        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[10];
            for(int j = 0; j < 9; j++) {
                if(!check[board[j][i]]) {
                    check[board[j][i]] = true;
                } else {
                    return 0;
                }
            }
        }
        
        // 3*3 확인
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                boolean[] check = new boolean[10];
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        if(!check[board[k + j*3][l + i*3]]) {
                            check[board[k + j*3][l + i*3]] = true;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
        
        return 1;
    }
}