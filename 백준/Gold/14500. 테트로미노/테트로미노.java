import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int board[][];
	static boolean[][] visited;
	static int N;
	static int M;
	static int max;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < M; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        max = 0;
        for(int i = 0;  i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		visited[i][j] = true;
        		method1(i, j, board[i][j], 0, visited);
        		visited[i][j] = false;
        		method2(i, j);
        	}
        	 
        }

        bw.append(max + "");
        bw.flush();
        
    }
	
	static void method1(int x, int y, int sum, int count, boolean[][] visited) {
		
		if(count == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int xx = x + dx[dir];
			int yy = y + dy[dir];
			
			if(xx < 0 || xx == N || yy < 0 || yy == M || visited[xx][yy]) {
				continue;
			}
			
			visited[xx][yy] = true;
			method1(xx, yy, sum + board[xx][yy], count + 1, visited);
			visited[xx][yy] = false;
		}
		
	}

	static void method2(int x, int y) {
		
		int sum = board[x][y];
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int dir = 0; dir < 4; dir++) {
			int xx = x + dx[dir];
			int yy = y + dy[dir];
			
			if(xx < 0 || xx == N || yy < 0 || yy == M) {
				continue;
			}
			
			count++;
			min = Math.min(board[xx][yy], min);
			sum += board[xx][yy];
		}
		
		if(count == 3) {
			max = Math.max(max, sum);
		} else if(count == 4) {
			max = Math.max(max, sum - min);
		}
	}
}