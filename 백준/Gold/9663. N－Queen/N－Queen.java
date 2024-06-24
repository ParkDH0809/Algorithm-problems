import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int answer;
	static int[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N];
		Arrays.fill(board, -1);

		backTrack(0);
		System.out.print(answer);
	}

	static void backTrack(int n) {
		if (n == N) {
			answer++;
			return;
		}

		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < n; j++) {
				if (board[j] == i || Math.abs(board[j] - i) == Math.abs(j - n)) {
					continue out;
				}
			}

			board[n] = i;
			backTrack(n + 1);
			board[n] = -1;
		}
	}

}