import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] graph;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		for (int n = 1; n <= N; n++) {
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(n);

			boolean[] selected = new boolean[N + 1];
			selected[n] = true;

			while (!queue.isEmpty()) {
				int current = queue.poll();
				for (int i : graph[current]) {
					if (!selected[i]) {
						selected[i] = true;
						queue.add(i);
						result[i]++;
					}
				}
			}
		}

		/*
		 * int max = 0; for (int i = 1; i <= N; i++) { max = Integer.max(result[i],
		 * max); }
		 * 
		 * StringBuilder sb = new StringBuilder(); for (int i = 1; i <= N; i++) { if
		 * (result[i] == max) { sb.append(i + " "); } }
		 */

		ArrayList<Integer> ans = new ArrayList<>();
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (result[i] > max) {
				max = result[i];
				ans.clear();
				ans.add(i);
			} else if (result[i] == max) {
				ans.add(i);
			}
		}

		for (int a : ans) {
			System.out.print(a + " ");
		}

//		System.out.print(sb);
	}
}
