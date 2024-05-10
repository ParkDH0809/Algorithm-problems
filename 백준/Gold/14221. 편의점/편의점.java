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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		boolean[] isHome = new boolean[n + 1];
		boolean[] isStore = new boolean[n + 1];
		List<Node>[] graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		int m = Integer.parseInt(st.nextToken());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		while (p-- > 0) {
			isHome[Integer.parseInt(st.nextToken())] = true;
		}

		st = new StringTokenizer(br.readLine());
		Queue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		while (q-- > 0) {
			int storeNumber = Integer.parseInt(st.nextToken());
			isStore[storeNumber] = true;
			pq.add(new Node(storeNumber, 0));
			distance[storeNumber] = 0;
		}
		
		boolean[] visited = new boolean[n+1];
		int answer = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();

			if(isHome[current.e]) {
				answer = current.e;
				break;
			}

			if(visited[current.e]) {
				continue;
			}

			visited[current.e] = true;
			for(Node node : graph[current.e]) {
				if(isStore[node.e]) {
					continue;
				}

				if(distance[current.e] + node.w < distance[node.e]) {
					distance[node.e] = distance[current.e] + node.w;
					pq.add(new Node(node.e, distance[node.e]));
				}
			}
		}

		System.out.print(answer);
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
		if(w == o.w) {
			return e - o.e;
		}
		return w - o.w;
	}

}