import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int min = Math.min(n1, n2);
			int max = Math.max(n1, n2);

			if (isSame(min, max)) {
				System.out.print(i + 1);
				return;
			}

			union(min, max);
		}

		System.out.print(0);
	}

	static void union(int n1, int n2) {
		int x = find(n1);
		int y = find(n2);

		if (x != y) {
			parent[y] = x;
		}
	}

	static int find(int n) {
		if (n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	static boolean isSame(int n1, int n2) {
		return find(n1) == find(n2);
	}
}
