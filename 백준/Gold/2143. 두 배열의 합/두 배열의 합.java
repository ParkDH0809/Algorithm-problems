import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				int sum = 0;
				for (int k = j; k <= j + i; k++) {
					sum += A[k];
				}
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		long answer = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m - i; j++) {
				int sum = 0;
				for (int k = j; k <= j + i; k++) {
					sum += B[k];
				}

				if (map.containsKey(T - sum)) {
					answer += map.get(T - sum);
				}
			}
		}

		System.out.print(answer);
	}
}
