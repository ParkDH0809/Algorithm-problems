import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int[] answer = new int[k + 1];
		Arrays.fill(answer, 100001);
		out: for (int i = 1; i < k + 1; i++) {
			for (int j = 0; j < n; j++) {
				if (i < arr[j]) {
					continue;
				}

				if (i == arr[j]) {
					answer[i] = 1;
					continue out;
				}

				answer[i] = Math.min(answer[i], answer[i - arr[j]] + 1);
			}
		}

		if (answer[k] == 100001) {
			System.out.print(-1);
		} else {
			System.out.print(answer[k]);
		}
	}
}