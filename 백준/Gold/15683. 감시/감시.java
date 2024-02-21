import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer= Integer.MAX_VALUE;
		int[][] map = new int[N][M];
		List<CCTV> cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}

		for (int i = cctvs.size() - 1; i >= 0; i--) {
			if (cctvs.get(i).type == 5) {
				workCctv5(cctvs.get(i), map);
				cctvs.remove(i);
			}
		}

		dfs(cctvs, map, 0);
		System.out.println(answer);
	}

	static void workCctv5(CCTV cctv, int[][] map) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int dir = 0; dir < 4; dir++) {
			int x = cctv.x;
			int y = cctv.y;

			while (true) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx == N || ny < 0 || ny == M || map[nx][ny] == 6) {
					break;
				}

				map[nx][ny] = cctv.type;
				x = nx;
				y = ny;
			}
		}
	}

	static void dfs(List<CCTV> cctvs, int[][] map, int depth) {
		if (depth == cctvs.size()) {
			answer = Math.min(answer, getAnswer(map));
			return;
		}

		CCTV currentCctv = cctvs.get(depth);
		for (int i = 0; i < currentCctv.numberOfCase; i++) {
			int[][] currentMap = deepCopyMap(map);
			workCctv(currentCctv, currentMap, i);
			dfs(cctvs, currentMap, depth + 1);
		}
	}

	static int[][] deepCopyMap(int[][] map) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, M);
		}
		return tmp;
	}

	static void workCctv(CCTV cctv, int[][] map, int currentCase) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		for(int dir : cctv.direction[currentCase]) {
			int x = cctv.x;
			int y = cctv.y;
			
			while (true) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if (nx < 0 || nx == N || ny < 0 || ny == M || map[nx][ny] == 6) {
					break;
				}
				
				map[nx][ny] = cctv.type;
				x = nx;
				y = ny;
			}
		}
	}

	static int getAnswer(int[][] map) {
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	static void print(int[][] map) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class CCTV {

	int x, y, type;
	int numberOfCase;
	int[][] direction;
	
	CCTV(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		if (type == 2) {
			this.numberOfCase = 2;
		} else {
			this.numberOfCase = 4;
		}
		
		switch(type) {
		case 1:
			direction = new int[][] {{0},{1},{2},{3}};
			break;
		case 2:
			direction = new int[][] {{0,2}, {1,3}};
			break;
		case 3:
			direction = new int[][] {{0,1}, {1,2}, {2,3}, {3,0}};
			break;
		case 4:
			direction = new int[][] {{0,1,2},{1,2,3},{2,3,0},{3,0,1}};
			break;
		}
	}

}