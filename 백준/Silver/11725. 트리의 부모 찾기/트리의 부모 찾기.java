import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		int[] answer = new int[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i : graph[current]) {
				if (answer[i] != 0) {
					continue;
				}

				answer[i] = current;
				queue.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.print(sb);
	}

}

class Node {

	int number;

	Node(int number) {
		this.number = number;
	}

}