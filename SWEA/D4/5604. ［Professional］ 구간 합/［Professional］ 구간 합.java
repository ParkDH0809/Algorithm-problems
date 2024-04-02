import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp = new long[16];
		dp[0] = 0;
		dp[1] = 45;
		for (int i = 2; i <= 15; i++) {
			dp[i] = dp[i - 1] * 10 + 45 * (long) Math.pow(10, i - 1);
		}

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long A = Long.parseLong(st.nextToken());
			Long B = Long.parseLong(st.nextToken());

			long answer = method(B) - method(A-1);

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	static long method(long n) {
		if (n <= 0) {
			return 0;
		}

		long answer = 0;
		long temp = n;
		int digit = 0;
		while (temp >= 10) {
			temp /= 10;
			digit++;
		}

		long remainder = n % (long) Math.pow(10, digit);

		for (int i = 1; i < temp; i++) {
			answer += i * (long) Math.pow(10, digit);
		}
		answer += dp[digit] * temp;
		answer += (remainder + 1) * temp;
		answer += method(remainder);
		return answer;
	}
}