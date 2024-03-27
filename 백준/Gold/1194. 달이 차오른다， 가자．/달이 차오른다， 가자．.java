import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static Queue<Player> playerPoints;
	static Point[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		playerPoints = new ArrayDeque<>();
		map = new Point[N][M];
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = new Point(input.charAt(c));
				if (map[r][c].value == '0') {
					playerPoints.add(new Player(r, c, 0));
					map[r][c].value = '.';
				}
			}
		}

		System.out.print(bfs());
	}

	static int bfs() {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int count = 1;
		while (!playerPoints.isEmpty()) {
			int size = playerPoints.size();

			while (size-- > 0) {
				Player player = playerPoints.poll();
				int r = player.r;
				int c = player.c;

				for (int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (!isRange(nr, nc)) {
						continue;
					}

					if (map[nr][nc].value == '#') {
						continue;
					}

					if (map[nr][nc].value == '1') {
						return count;
					}

					if (map[nr][nc].value == '.') {
						if (!map[nr][nc].visit[player.key]) {
							playerPoints.add(new Player(nr, nc, player.key));
							map[nr][nc].visit[player.key] = true;
						}
					}

					if ('a' <= map[nr][nc].value && map[nr][nc].value <= 'f') {
						if (!map[nr][nc].visit[player.key]) {
							map[nr][nc].visit[player.key] = true;
							playerPoints.add(new Player(nr, nc, player.key | (1 << (map[nr][nc].value - 'a'))));
						}
					}

					if ('A' <= map[nr][nc].value && map[nr][nc].value <= 'F') {
						int[] door = { 1, 2, 4, 8, 16, 32 };
						int index = map[nr][nc].value - 'A';
						if (!map[nr][nc].visit[player.key] && (player.key & door[index]) == door[index]) {
							playerPoints.add(new Player(nr, nc, player.key));
							map[nr][nc].visit[player.key] = true;
						}
					}
				}
			}
			count++;
		}
		return -1;
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

class Player {

	int r;
	int c;
	int key;

	Player(int r, int c, int key) {
		this.r = r;
		this.c = c;
		this.key = key;
	}

	public String toString() {
		return r + " " + c + "key: " + key;
	}

}

class Point {

	char value;
	boolean[] visit;

	Point(char value) {
		this.value = value;
		visit = new boolean[64];
	}

}