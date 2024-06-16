import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static String s1;
	static String s2;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		dp = new int[s1.length() + 1][s2.length() + 1];

		setDp();
		printResult(getLcs());
	}

	static void setDp() {
		for (int n1 = 1; n1 <= s1.length(); n1++) {
			for (int n2 = 1; n2 <= s2.length(); n2++) {
				if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
					dp[n1][n2] = dp[n1 - 1][n2 - 1] + 1;
				} else {
					dp[n1][n2] = Math.max(dp[n1][n2 - 1], dp[n1 - 1][n2]);
				}
			}
		}
	}

	static Stack<Character> getLcs() {
		int n1 = s1.length();
		int n2 = s2.length();
		Stack<Character> stack = new Stack<>();
		while (n1 != 0 && n2 != 0) {
			if (dp[n1][n2] == dp[n1 - 1][n2]) {
				n1--;
				continue;
			}

			if (dp[n1][n2] == dp[n1][n2 - 1]) {
				n2--;
				continue;
			}

			stack.add(s1.charAt(n1 - 1));
			n1--;
			n2--;
		}

		return stack;
	}

	static void printResult(Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		sb.append(dp[s1.length()][s2.length()]).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.print(sb);
	}
}