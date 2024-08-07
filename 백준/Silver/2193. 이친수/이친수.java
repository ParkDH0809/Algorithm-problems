import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N + 1];

		if (N >= 1) {
			arr[1] = 1;
		}
		if (N >= 2) {
			arr[2] = 1;
		}
		if (N >= 3) {
			arr[3] = 2;
		}

		for (int i = 4; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		System.out.print(arr[N]);
	}

}