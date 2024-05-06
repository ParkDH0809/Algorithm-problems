import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int E = Integer.parseInt(st.nextToken());

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int[] startDijk = dijkstra(1);
		if(startDijk[N] == Integer.MAX_VALUE) {
			System.out.print(-1);
			return;
		}
		
		int[] v1Dijk = dijkstra(v1);
		int[] v2Dijk = dijkstra(v2);
		System.out.print(Math.min(startDijk[v1] + v1Dijk[v2] + v2Dijk[N], startDijk[v2] + v2Dijk[v1] + v1Dijk[N]));
	}

	static int[] dijkstra(int start) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		boolean[] visited = new boolean[N + 1];

		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (visited[current.e]) {
				continue;
			}
			visited[current.e] = true;

			for (Node node : graph[current.e]) {
				if (distance[current.e] + node.w < distance[node.e]) {
					distance[node.e] = distance[current.e] + node.w;
					pq.add(new Node(node.e, distance[node.e]));
				}
			}
		}

		return distance;
	}

}

class Node implements Comparable<Node> {

	int e;
	int w;

	Node(int e, int w) {
		this.e = e;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return w - o.w;
	}
}