import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		parents = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parents[i] = i;
		}

		int P = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			if (find(g) == 0) {
				break;
			}

			int n = find(g);
			union(n - 1, n);
			answer++;
		}

		System.out.print(answer);
	}

	static void union(int n1, int n2) {
		int x = find(n1);
		int y = find(n2);

		if (x != y) {
			parents[y] = x;
		}
	}

	static int find(int n) {
		if (n == parents[n]) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}

	static boolean isSame(int n1, int n2) {
		return find(n1) == find(n2);
	}
}
