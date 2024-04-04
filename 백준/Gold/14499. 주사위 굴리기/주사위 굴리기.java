import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main
 */
public class Main {

	static int N;
	static int M;
	static int r;
	static int c;
	static int direction;
	static int[][] map;
	static Dice dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new Dice();
		direction = 1;
		st = new StringTokenizer(br.readLine());
		while (K-- > 0) {
			direction = Integer.parseInt(st.nextToken()) - 1;
			int current = play();
			if (current != -1) {
				sb.append(current).append("\n");
			}
		}

		System.out.print(sb);
	}

	static int play() {
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };

		int nr = r + dr[direction];
		int nc = c + dc[direction];

		if (!isRange(nr, nc)) {
			return -1;
		} else {
			r = nr;
			c = nc;
		}

		switch (direction) {
		case 0:
			dice.turnRight();
			break;
		case 1:
			dice.turnLeft();
			break;
		case 2:
			dice.turnBack();
			break;
		case 3:
			dice.turnFront();
			break;
		}
		
		if (map[r][c] == 0) {
			map[r][c] = dice.bottom;
		} else {
			dice.bottom = map[r][c];
			map[r][c] = 0;
		}

		return dice.top;
	}

	static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}

class Dice {

	int front;
	int back;
	int left;
	int right;
	int top;
	int bottom;

	Dice() {
		top = 0;
		bottom = 0;
		left = 0;
		right = 0;
		front = 0;
		back = 0;
	}

	void turnRight() {
		int tmp = top;
		top = left;
		left = bottom;
		bottom = right;
		right = tmp;
	}

	void turnLeft() {
		int tmp = top;
		top = right;
		right = bottom;
		bottom = left;
		left = tmp;
	}

	void turnFront() {
		int tmp = top;
		top = front;
		front = bottom;
		bottom = back;
		back = tmp;
	}

	void turnBack() {
		int tmp = top;
		top = back;
		back = bottom;
		bottom = front;
		front = tmp;
	}

}