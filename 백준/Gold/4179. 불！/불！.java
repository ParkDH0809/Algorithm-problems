import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Jihun.visited = new boolean[R][C];
		Fire.visited = new boolean[R][C];

		Queue<Jihun> jihuns = new ArrayDeque<>();
		Queue<Fire> fires = new ArrayDeque<>();
		for (int r = 0; r < R; r++) {
			String input = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = input.charAt(c);
				if (map[r][c] == 'F') {
					fires.add(new Fire(r, c));
					Fire.visited[r][c] = true;
					continue;
				}

				if (map[r][c] == 'J') {
					jihuns.add(new Jihun(r, c));
					Jihun.visited[r][c] = true;
				}
			}
		}

		int answer = play(jihuns, fires);
		if (answer == -1) {
			System.out.print("IMPOSSIBLE");
		} else {
			System.out.print(answer);
		}
	}

	static int play(Queue<Jihun> jihuns, Queue<Fire> fires) {
		int count = 1;
		while (!jihuns.isEmpty()) {
			spreadFire(fires);
			if (moveJihun(jihuns)) {
				return count;
			}
			count++;
		}

		return -1;
	}

	static void spreadFire(Queue<Fire> fires) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int size = fires.size();
		while (size-- > 0) {
			Fire fire = fires.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = fire.r + dr[dir];
				int nc = fire.c + dc[dir];

				if (!isInRange(nr, nc)) {
					continue;
				}

				if (map[nr][nc] == '#') {
					continue;
				}

				if (Fire.visited[nr][nc]) {
					continue;
				}

				fires.add(new Fire(nr, nc));
				Fire.visited[nr][nc] = true;
			}
		}
	}

	static boolean moveJihun(Queue<Jihun> jihuns) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int size = jihuns.size();
		while (size-- > 0) {
			Jihun jihun = jihuns.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = jihun.r + dr[dir];
				int nc = jihun.c + dc[dir];

				if (!isInRange(nr, nc)) {
					return true;
				}

				if (map[nr][nc] == '#') {
					continue;
				}

				if (Fire.visited[nr][nc]) {
					continue;
				}

				if (Jihun.visited[nr][nc]) {
					continue;
				}

				jihuns.add(new Jihun(nr, nc));
				Jihun.visited[nr][nc] = true;
			}
		}
		return false;
	}

	static boolean isInRange(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}

class Jihun {

	static boolean[][] visited;
	int r;
	int c;

	Jihun(int r, int c) {
		this.r = r;
		this.c = c;
	}

}

class Fire {

	static boolean[][] visited;
	int r;
	int c;

	Fire(int r, int c) {
		this.r = r;
		this.c = c;
	}

}