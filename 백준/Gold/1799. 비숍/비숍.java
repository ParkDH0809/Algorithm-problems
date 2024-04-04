import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int maxCase1;
	static int maxCase2;
	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = st.nextToken().equals("1") ? true : false;
			}
		}

		getCase1(0, 0, new int[N][N]);
		getCase2(0, 0, new int[N][N]);
		System.out.print(maxCase1 + maxCase2);
	}

	static void getCase1(int startR, int count, int[][] visited) {
		if (maxCase1 <= count) {
			maxCase1 = count;
		}

		for (int r = startR; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)) {
					if (visited[r][c] == 0 && board[r][c]) {
						changeVisitedValue(r, c, visited, 1);
						getCase1(r, count + 1, visited);
						changeVisitedValue(r, c, visited, -1);
					}
				}
			}
		}
	}

	static void getCase2(int startR, int count, int[][] visited) {
		if (maxCase2 < count) {
			maxCase2 = count;
		}

		for (int r = startR; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if ((r % 2 == 0 && c % 2 == 1) || (r % 2 == 1 && c % 2 == 0)) {
					if (visited[r][c] == 0 && board[r][c]) {
						changeVisitedValue(r, c, visited, 1);
						getCase2(r, count + 1, visited);
						changeVisitedValue(r, c, visited, -1);
					}
				}
			}
		}
	}

	static void changeVisitedValue(int r, int c, int[][] visited, int flag) {
		int[] dr = { 1, 1, -1, -1 };
		int[] dc = { 1, -1, 1, -1 };

		visited[r][c] += flag;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			while (isRange(nr, nc)) {
				visited[nr][nc] += flag;
				nr += dr[dir];
				nc += dc[dir];
			}
		}
	}

	static boolean isRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	static void print(int[][] visited) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(visited[r][c] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}