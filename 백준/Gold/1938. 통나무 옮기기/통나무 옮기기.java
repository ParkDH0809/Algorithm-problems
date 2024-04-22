import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] endPoint;
	static char[][] map;

	static boolean[][] rVisited;
	static boolean[][] cVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		int[][] trainPoint = new int[3][2];
		endPoint = new int[3][2];

		int trainCount = 0;
		int endPointCount = 0;
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = input.charAt(c);

				if (map[r][c] == 'B') {
					trainPoint[trainCount][0] = r;
					trainPoint[trainCount][1] = c;
					trainCount++;
					continue;
				}

				if (map[r][c] == 'E') {
					endPoint[endPointCount][0] = r;
					endPoint[endPointCount][1] = c;
					endPointCount++;
				}
			}
		}

		System.out.println(find(trainPoint));
	}

	static int find(int[][] start) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		rVisited = new boolean[N][N];
		cVisited = new boolean[N][N];

		Queue<int[][]> queue = new ArrayDeque<>();
		queue.add(start);
		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				int[][] currentPoint = queue.poll();
				// 1. 상하좌우
				for (int dir = 0; dir < 4; dir++) {
					int[][] nextPoint = new int[3][2];
					nextPoint[0][0] = currentPoint[0][0] + dr[dir];
					nextPoint[0][1] = currentPoint[0][1] + dc[dir];
					nextPoint[1][0] = currentPoint[1][0] + dr[dir];
					nextPoint[1][1] = currentPoint[1][1] + dc[dir];
					nextPoint[2][0] = currentPoint[2][0] + dr[dir];
					nextPoint[2][1] = currentPoint[2][1] + dc[dir];

					if (!canMove(nextPoint)) {
						continue;
					}

					if (visited(nextPoint)) {
						continue;
					}

					if (isAnswer(nextPoint)) {
						return count;
					}

					queue.add(nextPoint);
				}

				// 2. 회전
				if (canTurn(currentPoint)) {
					queue.add(getTurnPoint(currentPoint));
				}

			}
			count++;
		}

		return 0;
	}

	static boolean canMove(int[][] point) {
		for (int i = 0; i < 3; i++) {
			if (point[i][0] < 0 || point[i][0] >= N || point[i][1] < 0 || point[i][1] >= N) {
				return false;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (map[point[i][0]][point[i][1]] == '1') {
				return false;
			}
		}

		return true;
	}

	static boolean visited(int[][] point) {
		if (point[0][0] == point[1][0]) {
			if (rVisited[point[0][0]][point[0][1]] && rVisited[point[1][0]][point[1][1]]
					&& rVisited[point[2][0]][point[2][1]]) {
				return true;
			}

			rVisited[point[0][0]][point[0][1]] = true;
			rVisited[point[1][0]][point[1][1]] = true;
			rVisited[point[2][0]][point[2][1]] = true;
		} else {
			if (cVisited[point[0][0]][point[0][1]] && cVisited[point[1][0]][point[1][1]]
					&& cVisited[point[2][0]][point[2][1]]) {
				return true;
			}
			
			cVisited[point[0][0]][point[0][1]] = true;
			cVisited[point[1][0]][point[1][1]] = true;
			cVisited[point[2][0]][point[2][1]] = true;
		}

		return false;
	}

	static boolean isAnswer(int[][] point) {
		for (int i = 0; i < 3; i++) {
			if (!(point[i][0] == endPoint[i][0] && point[i][1] == endPoint[i][1])) {
				break;
			}

			if (i == 2) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (!(point[2 - i][0] == endPoint[i][0] && point[2 - i][1] == endPoint[i][1])) {
				break;
			}

			if (i == 2) {
				return true;
			}
		}

		return false;
	}

	static boolean canTurn(int[][] point) {
		for (int r = -1; r <= 1; r++) {
			for (int c = -1; c <= 1; c++) {
				int nr = point[1][0] + r;
				int nc = point[1][1] + c;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					return false;
				}

				if (map[nr][nc] == '1') {
					return false;
				}
			}
		}

		int[][] nextPoint = new int[3][2];
		int r = point[1][0];
		int c = point[1][1];
		if (point[0][0] == point[1][0]) {
			nextPoint[0][0] = r - 1;
			nextPoint[1][0] = r;
			nextPoint[2][0] = r + 1;
			nextPoint[0][1] = nextPoint[1][1] = nextPoint[2][1] = c;
		} else {
			nextPoint[0][1] = c - 1;
			nextPoint[1][1] = c;
			nextPoint[2][1] = c + 1;
			nextPoint[0][0] = nextPoint[1][0] = nextPoint[2][0] = r;
		}

		if (visited(nextPoint)) {
			return false;
		}

		return true;
	}

	static int[][] getTurnPoint(int[][] point) {
		int[][] nextPoint = new int[3][2];
		int r = point[1][0];
		int c = point[1][1];
		if (point[0][0] == point[1][0]) {
			nextPoint[0][0] = r - 1;
			nextPoint[1][0] = r;
			nextPoint[2][0] = r + 1;
			nextPoint[0][1] = nextPoint[1][1] = nextPoint[2][1] = c;
		} else {
			nextPoint[0][1] = c - 1;
			nextPoint[1][1] = c;
			nextPoint[2][1] = c + 1;
			nextPoint[0][0] = nextPoint[1][0] = nextPoint[2][0] = r;
		}
		return nextPoint;
	}

}