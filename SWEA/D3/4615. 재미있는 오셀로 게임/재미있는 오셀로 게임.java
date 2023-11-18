import java.util.*;
import java.io.*;

class Solution {
	static int[][] board;
	static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			board[N/2][N/2] = board[N/2-1][N/2-1] = 2;
			board[N/2][N/2-1] = board[N/2-1][N/2] = 1;
			
			for(int i = 0 ;i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken());
				
				method(x, y, r);
			}
			
			int b = 0;
			int w = 0;
			for(int i = 0; i < N; i++) {
				for(int n : board[i]) {
					if(n == 1) b++;
					else if(n == 2) w++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(b).append(" ").append(w).append("\n");
		}
        System.out.print(sb);
	}
	
	static void method(int x, int y, int r) {
		board[x][y] = r;
		
		int cor;
		if(r == 1) cor = 2;
		else cor = 1;
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(i == 0 && j == 0) continue;
				
				int mx = x + i;
				int my = y + j;
				int count = 0;
				boolean check = false;
				while(mx >= 0 && my >= 0 && mx < N && my < N && board[mx][my] != 0) {
					
					if (board[mx][my] == cor) {
						check = true;
					}
					
					if(board[mx][my] == r) {
						int chx = x;
						int chy = y;
						for(int c = 0; c < count; c++) {
							chx += i;
							chy += j;
							board[chx][chy] = r;
						}
						break;
					}
					mx = mx + i;
					my = my + j;
					count++;
				}
			}
		}
	}
}