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
	static int[] parents;
	static int N;
	static int L;
	static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while (isPossible()) {
			count++;
		}
		System.out.println(count);
	}

	static boolean isPossible() {
		boolean[][] visited = new boolean[N][N];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}

				int count = 0;
				int sum = 0;
				List<int[]> points = new ArrayList<>();
				points.add(new int[] { i, j });

				Queue<int[]> queue = new ArrayDeque<>();
				queue.add(new int[] { i, j });

				visited[i][j] = true;
				while (!queue.isEmpty()) {
					int[] point = queue.poll();
					int x = point[0];
					int y = point[1];
					for (int dir = 0; dir < 4; dir++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];

						if (nx < 0 || nx == N || ny < 0 || ny == N) {
							continue;
						}

						if (visited[nx][ny]) {
							continue;
						}

						int gap = Math.abs(map[nx][ny] - map[x][y]);
						if (L <= gap && gap <= R) {
							queue.add(new int[] { nx, ny });
							visited[nx][ny] = true;
							flag = true;
						}
					}
					count++;
					sum += map[x][y];
					points.add(new int[] { x, y });
				}

				int result = sum / count;
				for (int[] point : points) {
					map[point[0]][point[1]] = result;
				}
			}
		}
		return flag;
	}

}