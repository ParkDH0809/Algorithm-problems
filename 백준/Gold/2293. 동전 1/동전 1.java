import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
//		Arrays.sort(coins);

		int k = Integer.parseInt(st.nextToken());
		int[] result = new int[k + 1];
		result[0] = 1;
		for (int i : coins) {
			for(int j = i; j <= k; j++) {
				result[j] += result[j-i];
			}
		}

		System.out.print(result[k]);
	}
}