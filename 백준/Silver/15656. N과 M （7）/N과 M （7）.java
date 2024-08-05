import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int[] number;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);

		sb = new StringBuilder();
		method(new int[M], 0);
		System.out.print(sb);
	}

	static void method(int[] arr, int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(number[arr[i]]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[count] = i;
			method(arr, count + 1);
		}
	}

}