import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}

		boolean[] selected = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		selected[1] = true;
		queue.add(1);

		int count = -1;
		for (int i = 0; i < 3; i++) {
			int size = queue.size();
			while (size-- > 0) {
				int current = queue.poll();

				for (Integer n : graph.get(current)) {
					if (!selected[n]) {
						queue.add(n);
						selected[n] = true;
					}
				}

				count++;
			}
			
		}

		System.out.print(count);
	}
}