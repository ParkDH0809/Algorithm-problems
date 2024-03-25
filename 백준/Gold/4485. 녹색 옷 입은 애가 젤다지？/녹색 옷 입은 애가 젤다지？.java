import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int inputCase = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem ").append(inputCase++).append(": ").append(getAnswer()).append("\n");
		}
		System.out.print(sb);
	}

	static int getAnswer() {
		Point[][] minMap = new Point[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				minMap[r][c] = new Point(r, c, Integer.MAX_VALUE);
			}
		}
		
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.value - o2.value;
			}
		});
		
		minMap[0][0].value = map[0][0];
		pq.add(minMap[0][0]);
		
		while(true) {
			Point point = pq.poll();
			if(point.r == N-1 && point.c == N-1) {
				break;
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int nr = point.r + dr[dir];
				int nc = point.c + dc[dir];
				
				if(nr < 0 || nr == N || nc < 0 || nc == N) {
					continue;
				}
				
				if(point.value + map[nr][nc] < minMap[nr][nc].value) {
					minMap[nr][nc].value = point.value + map[nr][nc];
					pq.add(minMap[nr][nc]);
				}
			}
		}
		
		return minMap[N - 1][N - 1].value;
	}
}

class Point {
	int r;
	int c;
	int value;
	
	Point(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
	}
}