import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static Point[][] map;
	static Queue<Shark> sharks = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Shark.R = R;
		Shark.C = C;

		initMap();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());

			if (direction == 1) {
				direction = 2;
			} else if (direction == 2) {
				direction = 1;
			}

			Shark shark = new Shark(r, c, speed, direction, size);
			map[r][c].shark = shark;
			sharks.add(shark);
		}

		int answer = catchShark(0);
		for (int i = 1; i < C; i++) {
			initMap();
			moveSharks();
			answer += catchShark(i);
		}

		System.out.print(answer);
	}

	static void initMap() {
		map = new Point[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = new Point();
			}
		}
	}

	static int catchShark(int c) {
		int r = 0;
		while (r < R) {
			if (map[r][c].isEmpty()) {
				r++;
				continue;
			}
			map[r][c].shark.isDead = true;
			return map[r][c].shark.size;
		}
		return 0;
	}

	static void moveSharks() {
		int size = sharks.size();
		while (size-- > 0) {
			Shark shark = sharks.poll();
			if (shark.isDead) {
				continue;
			}

			int moveCount = shark.speed;
			if (shark.direction == 0 || shark.direction == 2) {
				moveCount %= R * 2 - 2;
			} else {
				moveCount %= C * 2 - 2;
			}

			shark.move(moveCount);
			map[shark.r][shark.c].setShark(shark);
			sharks.add(shark);
		}
	}
	
	static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Point {

	Shark shark;

	void setShark(Shark shark) {
		if (this.shark == null) {
			this.shark = shark;
			return;
		}

		if (this.shark.size > shark.size) {
			shark.isDead = true;
		} else {
			this.shark.isDead = true;
			this.shark = shark;
		}
	}

	boolean isEmpty() {
		return shark == null;
	}
	
	@Override
	public String toString() {
		return shark == null ? "0" : String.valueOf(shark.size);
	}
}

class Shark {

	static int R;
	static int C;

	int r;
	int c;
	int speed;
	int direction;
	int size;
	boolean isDead;

	public Shark(int r, int c, int speed, int direction, int size) {
		this.r = r;
		this.c = c;
		this.speed = speed;
		this.direction = direction;
		this.size = size;
	}

	void move(int moveCount) {
		if(moveCount == 0) {
			return;
		}
		
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int nr = r + dr[direction];
		int nc = c + dc[direction];
		
		if(isRange(nr,nc)) {
			r = nr;
			c = nc;	
		} else {
			direction = (direction + 2) % 4;
			r += dr[direction];
			c += dc[direction];
		}
		
		move(moveCount-1);
	}

	boolean isRange(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}