import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int r = 0; r < N; r++) {
			Arrays.fill(arr[r], ' ');
		}

		method(N, 0, 0);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int r = 0; r < N; r++) {
			bw.write(arr[r]);
			bw.write('\n');
		}
		bw.close();
	}

	static void method(int N, int r, int c) {
		if (N == 3) {
			arr[r][c] = arr[r][c + 1] = arr[r][c + 2] = '*';
			arr[r + 1][c] = arr[r + 1][c + 2] = '*';
			arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = '*';
		} else {
			method(N / 3, r, c);
			method(N / 3, r + N / 3, c);
			method(N / 3, r + N / 3 * 2, c);
			method(N / 3, r, c + N / 3);
			method(N / 3, r, c + N / 3 * 2);
			method(N / 3, r + N / 3 * 2, c + N / 3);
			method(N / 3, r + N / 3, c + N / 3 * 2);
			method(N / 3, r + N / 3 * 2, c + N / 3 * 2);
		}
	}

}