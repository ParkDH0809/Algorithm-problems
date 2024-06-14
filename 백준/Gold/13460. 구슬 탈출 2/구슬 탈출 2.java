import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static char[][] board;
	static boolean[][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M][N][M];

		Ball[] ballPoints = new Ball[2];
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				if (input.charAt(c) == 'R') {
					ballPoints[0] = new Ball(r, c, true);
					board[r][c] = '.';
					continue;
				}

				if (input.charAt(c) == 'B') {
					ballPoints[1] = new Ball(r, c, false);
					board[r][c] = '.';
					continue;
				}

				board[r][c] = input.charAt(c);
			}
		}

		System.out.print(bfs(ballPoints));
	}

	static int bfs(Ball[] ballPoints) {
		Queue<Ball[]> queue = new ArrayDeque<>();
		queue.add(ballPoints);

		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Ball[] current = queue.poll();
				for (int dir = 0; dir < 4; dir++) {
					Ball[] movePoints = new Ball[2];
					movePoints[0] = new Ball(current[0].r, current[0].c, true);
					movePoints[1] = new Ball(current[1].r, current[1].c, false);

					move(movePoints[0], movePoints[1], dir);
					move(movePoints[1], movePoints[0], dir);
					move(movePoints[0], movePoints[1], dir);

					if (movePoints[1].isComplete) {
						continue;
					}

					if (movePoints[0].isComplete) {
						return count;
					}

					if (!visited[movePoints[0].r][movePoints[0].c][movePoints[1].r][movePoints[1].c]) {
						visited[movePoints[0].r][movePoints[0].c][movePoints[1].r][movePoints[1].c] = true;
						queue.add(movePoints);
					}
				}
			}

			count++;
			if (count == 11) {
				break;
			}
		}

		return -1;
	}

	static void move(Ball curBall, Ball difBall, int dir) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		if (curBall.isComplete) {
			return;
		}

		while (true) {
			int nr = curBall.r + dr[dir];
			int nc = curBall.c + dc[dir];

			if (board[nr][nc] == '#') {
				break;
			}

			if (nr == difBall.r && nc == difBall.c) {
				break;
			}

			curBall.r = nr;
			curBall.c = nc;

			if (board[curBall.r][curBall.c] == 'O') {
				curBall.isComplete = true;
				curBall.r = 0;
				curBall.c = 0;
				break;
			}
		}
	}

}

class Ball {

	int r;
	int c;
	boolean isRed;
	boolean isComplete;

	Ball(int r, int c, boolean isRed) {
		this.r = r;
		this.c = c;
		this.isRed = isRed;
	}

	public String toString() {
		return r + " " + c;
	}

}