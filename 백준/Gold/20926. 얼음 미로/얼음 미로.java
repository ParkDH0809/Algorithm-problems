import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static Point[][] map;
	static int[] startPoint;
	static int[] endPoint;
	static int W;
	static int H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		startPoint = new int[2];
		endPoint = new int[2];

		map = new Point[H][W];
		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			for (int j = 0; j < W; j++) {
				char current = input.charAt(j);
				if (current == 'T') {
					startPoint[0] = i;
					startPoint[1] = j;
				} else if (current == 'E') {
					endPoint[0] = i;
					endPoint[1] = j;
				}

				map[i][j] = new Point(i, j, current, Integer.MAX_VALUE);
			}
		}

		map[startPoint[0]][startPoint[1]].t = '0';
		map[startPoint[0]][startPoint[1]].answer = 0;
		
		getAnswer();

		int result = map[endPoint[0]][endPoint[1]].answer;
		if (result == Integer.MAX_VALUE) {
			System.out.print(-1);
			return;
		}
		System.out.print(result);
	}

	static void getAnswer() {
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.answer - o2.answer;
			}
		});
		pq.add(map[startPoint[0]][startPoint[1]]);

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		while (!pq.isEmpty()) {
			Point current = pq.poll();
            
			if (current.t == 'E') {
				return;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int r = current.r;
				int c = current.c;
				int sum = map[r][c].answer;

				while (true) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					// 1. 범위를 벗어나거나 구멍을 만난 경우: 제외
					if (nr < 0 || nr == H || nc < 0 || nc == W || map[nr][nc].t == 'H') {
						break;
					}
					
					// 2. 바위를 만난 경우: 앞에서 멈춤. 가중치가 작으면 업데이트
					if (map[nr][nc].t == 'R') {
						if (map[r][c].answer > sum) {
							map[r][c].answer = sum;
							pq.add(map[r][c]);
						}
						break;
					}
					
					// 3. 출구를 만난 경우: 가중치 업데이트 후 멈춤.
					if(map[nr][nc].t == 'E') {
						if(map[nr][nc].answer > sum) {
							map[nr][nc].answer = sum;
							pq.add(map[nr][nc]);
						}
						break;
					}

					sum += map[nr][nc].t - '0';
					r = nr;
					c = nc;
				}
			}
		}
	}
}

class Point {
	int r;
	int c;
	char t;
	int answer;

	Point(int r, int c, char t, int answer) {
		this.r = r;
		this.c = c;
		this.t = t;
		this.answer = answer;
	}

	public String toString() {
		return r + " " + c + " " + t + " " + answer;
	}

}