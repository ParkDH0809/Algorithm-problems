import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int m = Integer.parseInt(st.nextToken());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				union(min, max);
			} else {
				if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}

		System.out.println(sb);
	}

	static void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);

		if (findA != findB) {
			parent[findB] = parent[a];
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}