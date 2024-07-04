import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int W;
	static int H;
	static int K;
	static Point[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		if (W == 1 && H == 1) {
			System.out.print(0);
			return;
		}

		map = new Point[H][W];
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = new Point(h, w, st.nextToken().equals("1"), K);
			}
		}
		System.out.print(bfs());
	}

	static int bfs() {
		int[] dr = { 0, 1, 0, -1, -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dc = { 1, 0, -1, 0, -1, 1, -2, 2, -2, 2, -1, 1 };

		Queue<Monkey> queue = new ArrayDeque<>();
		queue.add(new Monkey(0, 0, 0));

		int bfsCount = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Monkey monkey = queue.poll();

				for (int dir = 0; dir < 12; dir++) {
					int nr = monkey.r + dr[dir];
					int nc = monkey.c + dc[dir];

					if (!isInRange(nr, nc)) {
						continue;
					}

					if (map[nr][nc].isWall) {
						continue;
					}

					if (dir < 4 && map[nr][nc].isVisited[monkey.jumpCount]) {
						continue;
					}

					if (dir >= 4 && (monkey.jumpCount + 1 > K || map[nr][nc].isVisited[monkey.jumpCount + 1])) {
						continue;
					}

					if (isFinished(nr, nc)) {
						return bfsCount;
					}

					if (dir < 4) {
						map[nr][nc].isVisited[monkey.jumpCount] = true;
						queue.add(new Monkey(nr, nc, monkey.jumpCount));
					} else {
						map[nr][nc].isVisited[monkey.jumpCount + 1] = true;
						queue.add(new Monkey(nr, nc, monkey.jumpCount + 1));
					}
				}
			}
			bfsCount++;
		}
		return -1;
	}

	static boolean isInRange(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	static boolean isFinished(int r, int c) {
		return r == H - 1 && c == W - 1;
	}

}

class Monkey {

	int r;
	int c;
	int jumpCount;

	Monkey(int r, int c, int jumpCount) {
		this.r = r;
		this.c = c;
		this.jumpCount = jumpCount;
	}

}

class Point {

	int r;
	int c;
	boolean isWall;
	boolean[] isVisited;

	Point(int r, int c, boolean isWall, int K) {
		this.r = r;
		this.c = c;
		this.isWall = isWall;
		isVisited = new boolean[K + 1];
	}
    
}