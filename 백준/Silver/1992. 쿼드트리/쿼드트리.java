import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] board;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = input.charAt(j) == '1' ? true : false;
			}
		}
		
		checkBoard(0, 0, N);
		System.out.println(sb);
	}
	
	static void checkBoard(int r, int c, int n) {
		boolean flag = board[r][c];
		boolean isCorrect = true;
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(flag != board[i][j]) {
					isCorrect = false;
					break;
				}
			}
		}
		
		if(isCorrect) {
			if(flag) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		} else {
			sb.append("(");
			checkBoard(r, c, n/2);
			checkBoard(r, c + n/2, n/2);
			checkBoard(r + n/2, c, n/2);
			checkBoard(r + n/2, c + n/2, n/2);
			sb.append(")");
		}
	}

}