import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V;
	static int E;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new List[V + 1];
		for (int v = 1; v <= V; v++) {
			graph[v] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}

		System.out.print(prim(1));
	}

	static int prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		boolean[] visited = new boolean[V + 1];
		int result = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (visited[node.to]) {
				continue;
			}
			visited[node.to] = true;

			for (Node next : graph[node.to]) {
				if (!visited[next.to])
					pq.add(next);
			}

			result += node.weight;
		}

		return result;
	}

}

class Node implements Comparable<Node> {
	int weight;
	int to;

	Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}

}