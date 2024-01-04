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
            int[][] answer = new int[N][N];
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int dir = 0;
            int x = 0;
            int y = 0;
            for(int i = 1; i <= N*N; i++) {
                answer[x][y] = i;
                int xx = x + dx[dir];
                int yy = y + dy[dir];
                
                if(xx < 0 || xx == N || yy < 0 || yy == N || answer[xx][yy] != 0)
                    dir = (dir + 1) % 4;
                
                x += dx[dir];
                y += dy[dir];
            }
            
            bw.append("#" + test_case);
            bw.newLine();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    bw.append(answer[i][j] + " ");
                bw.newLine();
            }
		}
        bw.flush();
	}
}