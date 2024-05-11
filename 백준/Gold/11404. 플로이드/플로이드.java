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

	static List<Node>[] graph;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int[] distance = dijkstra(i);
			for (int j = 1; j <= n; j++) {
				if(distance[j] == Integer.MAX_VALUE) {
					sb.append("0 ");
				} else {
					sb.append(distance[j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static int[] dijkstra(int start) {
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		boolean[] visited = new boolean[n + 1];

		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if(visited[current.e]) {
				continue;
			}

			visited[current.e] = true;
			for (Node node : graph[current.e]) {
				if(distance[current.e] + node.w < distance[node.e]) {
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