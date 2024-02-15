import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int answer;
	static char[][] board;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray(); 
		}
		selected = new boolean[26];
		
		selected[board[0][0] - 'A'] = true;
		getAnswer(0, 0, 1);
		
		System.out.println(answer);
	}
	
	static void getAnswer(int r, int c, int count) {
		answer = Math.max(answer, count);
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr < 0 || nr == R || nc < 0 || nc == C || selected[board[nr][nc] - 'A']) {
				continue;
			}
			
			selected[board[nr][nc] - 'A'] = true;
			getAnswer(nr, nc, count+1);
			selected[board[nr][nc] - 'A'] = false;
			
		}
	}
}
