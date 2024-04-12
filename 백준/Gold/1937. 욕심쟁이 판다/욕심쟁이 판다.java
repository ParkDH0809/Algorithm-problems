import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int answer;
	static int[][] map;
	static int[][] maxValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		maxValue = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				answer = Math.max(answer, find(r, c, 1));
			}
		}
		
		System.out.print(answer + 1);
	}

	static int find(int r, int c, int depth) {
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (!isRange(nr, nc)) {
				continue;
			}

			if (map[r][c] >= map[nr][nc]) {
				continue;
			}

			if (maxValue[nr][nc] == 0) {
				maxValue[r][c] = Math.max(maxValue[r][c], find(nr, nc, depth) + 1);
			} else {
				maxValue[r][c] = Math.max(depth + maxValue[nr][nc], maxValue[r][c]);
			}
		}

		return maxValue[r][c];
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}