import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int K;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == 1 && M == 1) {
			System.out.print(1);
			return;
		}

		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = input.charAt(c);
			}
		}

		System.out.print(getAnswer());
	}

	static int getAnswer() {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		boolean[][][] visited = new boolean[K + 1][N][M];
		visited[0][0][0] = true;

		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0));

		int count = 2;
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				Point point = queue.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = point.r + dr[dir];
					int nc = point.c + dc[dir];

					if (!isRange(nr, nc)) {
						continue;
					}

					if (visited[point.getBrakeNumber()][nr][nc]) {
						continue;
					}

					if (isAnswer(nr, nc)) {
						return count;
					}

					if (map[nr][nc] == '1' && point.brakeCount == K) {
						continue;
					}

					if (map[nr][nc] == '0') {
						queue.add(new Point(nr, nc, point.brakeCount));
					}

					if (map[nr][nc] == '1') {
						queue.add(new Point(nr, nc, point.brakeCount + 1));
					}

					visited[point.getBrakeNumber()][nr][nc] = true;
				}
			}
			count++;
		}

		return -1;
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static boolean isAnswer(int r, int c) {
		return r == N - 1 && c == M - 1;
	}

	static class Point {

		int r;
		int c;
		int brakeCount;

		Point(int r, int c, int brakeCount) {
			this.r = r;
			this.c = c;
			this.brakeCount = brakeCount;
		}

		int getBrakeNumber() {
			return brakeCount;
		}

		public String toString() {
			return r + " " + c + " " + brakeCount;
		}
	}
}
