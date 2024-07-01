import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int sum;
	static int answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		play(new Tornado(N, 0));
		System.out.print(answer);
	}

	static void play(Tornado tornado) {
		while (!tornado.isEnd()) {
			sum = 0;
			tornado.move();
			moveSands(tornado);
		}
	}

	static void moveSands(Tornado tornado) {
		int sands = map[tornado.r][tornado.c];
		map[tornado.r][tornado.c] = 0;

		right(sands, tornado.r + dr[(tornado.direction + 3) % 4], tornado.c + dc[(tornado.direction + 3) % 4],
				(tornado.direction + 3) % 4);
		left(sands, tornado.r + dr[(tornado.direction + 1) % 4], tornado.c + dc[(tornado.direction + 1) % 4],
				(tornado.direction + 1) % 4);
		front(sands, tornado.r + dr[tornado.direction], tornado.c + dc[tornado.direction], tornado.direction);
	}

	static void right(int sands, int r, int c, int direction) {
		checkPoint(sands, r, c, 0.07);
		checkPoint(sands, r + dr[direction], c + dc[direction], 0.02);
		checkPoint(sands, r + dr[(direction + 1) % 4], c + dc[(direction + 1) % 4], 0.1);
		checkPoint(sands, r + dr[(direction + 3) % 4], c + dc[(direction + 3) % 4], 0.01);
	}

	static void left(int sands, int r, int c, int direction) {
		checkPoint(sands, r, c, 0.07);
		checkPoint(sands, r + dr[direction], c + dc[direction], 0.02);
		checkPoint(sands, r + dr[(direction + 1) % 4], c + dc[(direction + 1) % 4], 0.01);
		checkPoint(sands, r + dr[(direction + 3) % 4], c + dc[(direction + 3) % 4], 0.1);
	}

	static void front(int sands, int r, int c, int direction) {
		checkPoint(sands, r + dr[direction], c + dc[direction], 0.05);
		checkAlphaPoint(sands - sum, r, c);
	}

	static void checkPoint(int sands, int r, int c, double d) {
		if (isInRange(r, c)) {
			map[r][c] += (int) (sands * d);
		} else {
			answer += (int) (sands * d);
		}
		sum += (int) (sands * d);
	}

	static void checkAlphaPoint(int sands, int r, int c) {
		if (isInRange(r, c)) {
			map[r][c] += sands;
		} else {
			answer += sands;
		}
	}

	static boolean isInRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	static void print() {
		System.out.println();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}

class Tornado {

	int r;
	int c;
	int N;
	int direction;
	boolean[][] visited;

	Tornado(int N, int direction) {
		this.N = N;
		this.r = N / 2;
		this.c = N / 2;
		this.direction = direction;
		visited = new boolean[N][N];

		visited[r][c] = true;
	}

	void move() {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		int nd = (direction + 1) % 4;
		if (!visited[r + dr[nd]][c + dc[nd]]) {
			direction = nd;
		}

		r += dr[direction];
		c += dc[direction];
		visited[r][c] = true;
	}

	boolean isEnd() {
		return r == 0 && c == 0;
	}

}