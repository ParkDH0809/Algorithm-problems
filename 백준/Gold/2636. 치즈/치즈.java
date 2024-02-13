import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count;
	static int size;
	static int R;
	static int C;
	static boolean[][] board;
	static boolean[][] visited;
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new boolean[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				board[r][c] = st.nextToken().equals("0") ? false : true;
			}
		}
		
		count = 0;
		size = 1;
		int lastSize = 0;
		while(size != 0) {
			lastSize = size;
			getAnswer();
		}
		
		sb.append(count - 1 +"\n");
		sb.append(lastSize);
		System.out.println(sb);
	}
	
	static void getAnswer() {
		visited = new boolean[R][C];
		size = 0;
		visitBoard(count, count);
		count++;
	}
	
	static void visitBoard(int r, int c) {
		visited[r][c] = true;
		
		if(board[r][c]) {
			board[r][c] = false;
			size++;
			return;
		}
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for(int dir = 0; dir < 4; dir++) {
			int rr = r + dr[dir];
			int cc = c + dc[dir];
			
			if(rr < count || rr == R-count || cc < count || cc == C-count || visited[rr][cc]) {
				continue;
			}
			
			visitBoard(rr, cc);
		}
	}
}