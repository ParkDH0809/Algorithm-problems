import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int points;
	static Point[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Point[N][M];
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = new Point(r, c, input.charAt(c) == '1');
			}
		}

		initPointNumbers();
		System.out.println(getAnswer(initNumberHashMap()));
	}

	static void initPointNumbers() {
		int number = 1;
		boolean[][] visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c].isWall) {
					continue;
				}

				if (map[r][c].number == 0) {
					initNumber(map[r][c], number++, visited);
				}
			}
		}
	}

	static void initNumber(Point point, int number, boolean[][] visited) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		visited[point.r][point.c] = true;
		point.number = number;
		for (int dir = 0; dir < 4; dir++) {
			int nr = point.r + dr[dir];
			int nc = point.c + dc[dir];

			if (!isRange(nr, nc)) {
				continue;
			}

			if (visited[nr][nc]) {
				continue;
			}

			if (map[nr][nc].isWall) {
				continue;
			}

			initNumber(map[nr][nc], number, visited);
		}
	}

	static Map<Integer, Integer> initNumberHashMap() {
		Map<Integer, Integer> numberMap = new HashMap<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c].isWall) {
					continue;
				}
				numberMap.put(map[r][c].number, numberMap.getOrDefault(map[r][c].number, 0) + 1);
			}
		}
		return numberMap;
	}

	static StringBuilder getAnswer(Map<Integer, Integer> numberMap) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c].isWall) {
					sb.append((getNumber(map[r][c], numberMap) + 1) % 10);
				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		return sb;
	}

	static int getNumber(Point point, Map<Integer, Integer> numberMap) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int number = 0;
		Set<Integer> numberSet = new HashSet<>();
		for (int dir = 0; dir < 4; dir++) {
			int nr = point.r + dr[dir];
			int nc = point.c + dc[dir];

			if (!isRange(nr, nc)) {
				continue;
			}

			if (map[nr][nc].isWall) {
				continue;
			}

			if (numberSet.contains(map[nr][nc].number)) {
				continue;
			}

			numberSet.add(map[nr][nc].number);
			number += numberMap.get(map[nr][nc].number);
		}

		return number;
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c].number);
			}
			System.out.println();
		}
	}

}

class Point {

	int r;
	int c;
	int number;
	boolean isWall;

	Point(int r, int c, boolean isWall) {
		this.r = r;
		this.c = c;
		this.isWall = isWall;
	}

}