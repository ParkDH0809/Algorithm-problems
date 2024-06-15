import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int K;
	static int[] minsuCards;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		initNMK(new StringTokenizer(br.readLine()));
		initMinsuCards(new StringTokenizer(br.readLine()));
		initParents();
		System.out.print(getAnswer(new StringTokenizer(br.readLine())));
	}

	static void initNMK(StringTokenizer st) {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	static void initMinsuCards(StringTokenizer st) {
		minsuCards = new int[M + 2];
		for (int i = 1; i <= M; i++) {
			minsuCards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(minsuCards);
	}

	static void initParents() {
		parents = new int[N + 2];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	static StringBuilder getAnswer(StringTokenizer st) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {

			int minsuCard = find(binarySearch(Integer.parseInt(st.nextToken())));
			sb.append(minsuCards[minsuCard]).append("\n");
			union(minsuCard, minsuCard + 1);
		}
		return sb;
	}

	static int binarySearch(int n) {
		int start = 1;
		int end = minsuCards.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (n < minsuCards[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	static void union(int n1, int n2) {
		int x = find(n1);
		int y = find(n2);
		if (x != y) {
			parents[x] = parents[y];
		}
	}

	static int find(int n) {
		if (n != parents[n]) {
			parents[n] = find(parents[n]);
		}
		return parents[n];
	}

}