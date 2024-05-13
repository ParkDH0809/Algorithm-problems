import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int max = -1001;
		int sum = 0;
		for (int i : numbers) {
			sum += i;
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}

		System.out.print(max);
	}
}