import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
			}
		}

		System.out.println(arr[0][0]);
	}

}