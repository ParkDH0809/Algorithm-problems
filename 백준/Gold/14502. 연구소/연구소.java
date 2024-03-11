import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;
	static int M;
	static int minVirusNumber;
	static List<Point> virusPoints;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virusPoints = new ArrayList<>();

		int wallNumber = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					wallNumber++;
				} else if (map[i][j] == 2) {
					virusPoints.add(new Point(i, j));
				}
			}
		}
		minVirusNumber = Integer.MAX_VALUE;

		buildWall(0, 0);
		System.out.print(N * M - (minVirusNumber + wallNumber + 3));
	}

	static void buildWall(int count, int number) {
		if (count == 3) {
			getAnswer();
			return;
		}

		for (int i = number; i < N * M; i++) {
			int r = i / M;
			int c = i % M;
			if (map[r][c] == 0) {
				map[r][c] = 1;
				buildWall(count + 1, i + 1);
				map[r][c] = 0;
			}
		}
	}

	static void getAnswer() {
		boolean[][] visited = new boolean[N][M];
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int count = 0;

		for (Point virusPoint : virusPoints) {
			Queue<Point> points = new ArrayDeque<>();
			visited[virusPoint.r][virusPoint.c] = true;
			points.add(virusPoint);

			while (!points.isEmpty()) {
				Point current = points.poll();
				int r = current.r;
				int c = current.c;

				for (int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					if (nr < 0 || nr == N || nc < 0 || nc == M) {
						continue;
					}

					if (visited[nr][nc] || map[nr][nc] != 0) {
						continue;
					}

					points.add(new Point(nr, nc));
					visited[nr][nc] = true;
				}

				count++;

				if (minVirusNumber <= count) {
					return;
				}
			}
		}

		minVirusNumber = Math.min(count, minVirusNumber);
	}
}

class Point {
	int r;
	int c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	@Override
	public String toString() {
		return r + " " + c;
	}
}