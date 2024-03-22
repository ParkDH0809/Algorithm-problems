import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static boolean[][] visited;
	static boolean isAnswer;
	static int[][] map;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		int answer = 0;
		for(int r = 0; r < N; r++ ) {
			for(int c = 0; c < M; c++) {
				isAnswer = true;
				if(visited[r][c]) {
					continue;
				}
				
				isPeak(r, c, map[r][c]);
				if(isAnswer) {
					answer++;
				}
			}
		}
		
		System.out.print(answer);
	}
	
	static void isPeak(int r, int c, int number) {
		visited[r][c] = true;
		
		int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
		int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
		
		for(int dir = 0; dir < 8; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr < 0 || nr == N || nc < 0 || nc == M) {
				continue;
			}
			
			if(map[nr][nc] > number) {
				isAnswer = false;
			}
			
			if(number == map[nr][nc] && !visited[nr][nc]) {
				isPeak(nr, nc, number);
			}
		}
	}
}