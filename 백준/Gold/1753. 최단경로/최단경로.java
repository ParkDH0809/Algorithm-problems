import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		int startNode = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		int[] distance = new int[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[startNode] = 0;
		pq.add(new Node(startNode, 0));
		
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int weight = currentNode.weight;
			int node = currentNode.nextNode;
			
			if(weight > distance[node]) {
				continue;
			}
			
			for(Node next : graph.get(node)) {
				if(weight + next.weight < distance[next.nextNode]) {
					distance[next.nextNode] = weight + next.weight;
                    pq.add(new Node(next.nextNode, distance[next.nextNode]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			sb.append(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF").append("\n");
		}
		System.out.println(sb);
	}

}

class Node {
	
	int nextNode;
	int weight;
	
	Node(int nextNode, int weight) {
		this.nextNode = nextNode;
		this.weight = weight;
	}
}