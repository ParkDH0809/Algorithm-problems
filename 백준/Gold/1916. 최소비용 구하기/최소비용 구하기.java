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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new Node(e, w));
		}

		st = new StringTokenizer(br.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());

		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startPoint, 0));

		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startPoint] = 0;

		while(!pq.isEmpty()) {
			Node current = pq.poll();

			if(visited[current.e]) {
				continue;
			}
			visited[current.e] = true;

			for(Node node : graph[current.e]) {
				if(distance[current.e] + node.w < distance[node.e]) {
					distance[node.e] = distance[current.e] + node.w;
					pq.add(new Node(node.e, distance[node.e]));
				}
			}
		}

		System.out.print(distance[endPoint]);
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