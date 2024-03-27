import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] map;
	static Point dPoint;
	static Queue<Point> sPoints;
	static Queue<Point> wPoints;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		sPoints = new ArrayDeque<>();
		wPoints = new ArrayDeque<>();
		map = new char[R][C];
		for(int r = 0; r < R; r++) {
			String input = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == 'D') {
					dPoint = new Point(r, c);
					continue;
				}

				if(map[r][c] == 'S') {
					sPoints.add(new Point(r, c));
					continue;
				}
				
				if(map[r][c] == '*') {
					wPoints.add(new Point(r, c));
				}
			}
		}
		
		int answer = play();
		if(answer == -1) {
			System.out.print("KAKTUS");
			return;
		}
		System.out.print(answer);
	}
	
	static int play() {
		int count = 0;
		while(!sPoints.isEmpty()) {
			count++;
			if(moveDochi()) {
				return count;				
			}
			moveWater();
		}
		return -1;
	}
	
	static void moveWater() {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int size = wPoints.size();
		while(size-- > 0) {
			Point point = wPoints.poll();
			int r = point.r;
			int c = point.c;
			
			for(int dir = 0; dir < 4; dir++ ) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(!isRange(nr, nc)) {
					continue;
				}
				
				if(map[nr][nc] == 'X' || map[nr][nc] == 'D' || map[nr][nc] == '*') {
					continue;
				}
				
				map[nr][nc] = '*';
				wPoints.add(new Point(nr, nc));
			}
		}
	}
	
	static boolean moveDochi() {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int size = sPoints.size();
		while(size-- > 0) {
			Point point = sPoints.poll();
			int r = point.r;
			int c = point.c;
			
			if(map[r][c] == '*') {
				continue;
			}
			
			for(int dir = 0; dir < 4; dir++ ) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(!isRange(nr, nc)) {
					continue;
				}
				
				if(map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc] == 'S') {
					continue;
				}
				
				if(map[nr][nc] == 'D') {
					return true;
				}
				
				map[nr][nc] = 'S';
				sPoints.add(new Point(nr,nc));
			}
		}
		
		return false;
	}
	
	static boolean isRange(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static void print() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Point {
	int r;
	int c;
	
	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}