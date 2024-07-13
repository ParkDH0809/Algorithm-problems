import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N * 2 + 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}

		method(N, 0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				sb.append(arr[r][c]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static void method(int N, int r, int c) {
		if (N == 3) {
			arr[r][c] = '*';
			arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
			arr[r + 2][c - 2] = arr[r + 2][c - 1] = arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = '*';
		} else {
			method(N / 2, r, c);
			method(N / 2, r + N / 2, c - N / 2);
			method(N / 2, r + N / 2, c + N / 2);
		}
	}

}