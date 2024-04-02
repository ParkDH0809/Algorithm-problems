import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	static int N;
	static int answer;
	static Point[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new Point[N][N];
			for (int r = 0; r < N; r++) {
				String input = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = new Point(r, c, input.charAt(c) - '0');
				}
			}
			
			answer = 0;
			getAnswer();
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}		
		System.out.print(sb);
	}

	static void getAnswer() {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		map[0][1].sum = map[0][1].value;
		map[1][0].sum = map[1][0].value;
		pq.add(map[0][1]);
		pq.add(map[1][0]);
		while(!pq.isEmpty()) {
			Point point = pq.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nr = point.r + dr[dir];
				int nc = point.c + dc[dir];
				
				if(nr == N-1 && nc == N-1) {
					answer = point.sum;
					return;
				}
				
				if(!isRange(nr, nc)) {
					continue;
				}
				
				if(map[nr][nc].sum <= point.sum + map[nr][nc].value) {
					continue;
				}
				
				map[nr][nc].sum = point.sum + map[nr][nc].value;
				pq.add(map[nr][nc]);
			}
		}
	}
	
	static boolean isRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}

class Point implements Comparable<Point> {
	
	int r;
	int c;
	int value;
	int sum;
	
	Point(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
		this.sum = Integer.MAX_VALUE;
	}
	
	@Override
	public int compareTo(Point o) {
		if(sum != o.sum) {
			return sum - o.sum;	
		}
		return value - o.value;
	}
	
	@Override
	public String toString() {
		return r + " " + c + " " + value + " " + sum;
	}
}