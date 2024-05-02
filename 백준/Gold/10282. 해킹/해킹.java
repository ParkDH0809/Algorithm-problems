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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			List<Node>[] graph = new ArrayList[n+1];
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			while (d-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				graph[b].add(new Node(a, s));
			}
			
			
			boolean[] visited = new boolean[n+1];
			int[] distance = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[c] = 0;
			
			Queue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(c, 0));
		
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if(visited[node.node]) {
					continue;
				}
				
				visited[node.node] = true;
				for(Node next : graph[node.node]) {
					if(distance[node.node] + next.weight < distance[next.node]) {
						distance[next.node] = distance[node.node] + next.weight;
						pq.add(new Node(next.node, distance[next.node]));
					}
				}
			}
			
			int max = 0;
			int count = 0;
			for(int i : distance) {
				if(i == Integer.MAX_VALUE) {
					continue;
				}
				
				max = Math.max(max, i);
				count++;
			}
			
			sb.append(count).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}
}

class Node implements Comparable<Node> {
	
	int node;
	int weight;
	
	Node (int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}