import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		sb.append(getAnswer()).append(" ");
		changeGtoR();
		sb.append(getAnswer());

		System.out.println(sb);
	}
	
	static int getAnswer() {
		int answer = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visitMap(i, j);
					answer++;
				}
			}
		}
		return answer;
	}

	static void visitMap(int r, int c) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		visited[r][c] = true;
		for(int dir = 0; dir < 4; dir++) {
			int rr = r + dr[dir];
			int cc = c + dc[dir];
			
			if(rr < 0 || rr == N || cc < 0 || cc == N 
					|| visited[rr][cc] || map[r][c] != map[rr][cc]) {
				continue;
			}
			
			visitMap(rr, cc);
		}
	}
	
	static void changeGtoR() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
	}
}