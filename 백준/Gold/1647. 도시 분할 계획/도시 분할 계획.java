import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}

		System.out.println(prim(1));
	}

	static int prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		boolean[] visited = new boolean[N + 1];
		int max = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (visited[node.to]) {
				continue;
			}

			visited[node.to] = true;

			for (Node next : graph[node.to]) {
				if (!visited[next.to]) {
					pq.add(next);
				}
			}

			sum += node.weight;
			max = Math.max(max, node.weight);
		}
		return sum - max;
	}

}

class Node implements Comparable<Node> {

	int to;
	int weight;

	Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}