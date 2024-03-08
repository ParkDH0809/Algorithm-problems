import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int N;
	static int M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, dir);
		System.out.println(answer);
	}
	
	static void clean(int r, int c, int dir) {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
		if(map[r][c] == 0) {
			answer++;
			map[r][c] = 2;
		}
		
		boolean isClean = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(map[nr][nc] == 0) {
				isClean = false;
				break;
			}
		}
		
		// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우(4칸이 모두 청소된 경우)	
		if(isClean) {
			int backDir = (dir + 2) % 4;
			int nr = r + dr[backDir];
			int nc = c + dc[backDir];

			// 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
			if(map[nr][nc] != 1) {
				clean(nr, nc, dir);
			}
			// 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
			else {
				return;
			}
		} 
		// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
		else {
			// 3-1. 반시계 방향으로 90도 회전한다.
			int nextDir = dir;
			for(int i = 0; i < 4; i++) {
				nextDir = nextDir - 1;
				if(nextDir == -1) {
					nextDir = 3;
				}
				
				int nr = r + dr[nextDir];
				int nc = c + dc[nextDir];
				if(map[nr][nc] == 0) {
					clean(nr, nc, nextDir);
					break;
				}
			}
		}
	}
}