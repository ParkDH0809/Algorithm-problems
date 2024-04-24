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

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);

		int n1 = 0;
		int n2 = -1;
		int n3 = 0;
		boolean[] selected = new boolean[N + 1];
		selected[1] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			n3 = size;
			n1 = 20001;
			while (size-- > 0) {
				int current = queue.poll();
				for (Integer i : graph.get(current)) {
					
					if (selected[i]) {
						continue;
					}

					selected[i] = true;
					queue.add(i);
				}
				n1 = Math.min(n1, current);
			}
			n2++;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(n1).append(" ").append(n2).append(" ").append(n3);
		System.out.print(sb);
	}
}