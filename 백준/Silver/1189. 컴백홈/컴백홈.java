import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int K;
	static int answer;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean[][] visited = new boolean[R][C];
		visited[R-1][0] = true;
		getAnswer(R-1, 0, 1, visited);
		System.out.print(answer);
	}
	
	static void getAnswer(int r, int c, int count, boolean[][] visited) {
		if(count == K) {
			if(r == 0 && c == C-1) {
				answer++;
			}
			return;
		}
		
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr < 0 || nr == R || nc < 0 || nc == C) {
				continue;
			}
			
			if(visited[nr][nc] || map[nr][nc] == 'T') {
				continue;
			}
			
			visited[nr][nc] = true;
			getAnswer(nr, nc, count+1, visited);
			visited[nr][nc] = false;
		}
	}
}

