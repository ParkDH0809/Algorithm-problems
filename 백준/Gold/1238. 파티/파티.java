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
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			graph[A].add(new Node(B, T));
		}

		int[] xToEachNode = getDistances(X);
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(i == X) {
				continue;
			}

			int eachNodeToX = getDistances(i)[X];
			answer = Math.max(xToEachNode[i] + eachNodeToX, answer);
		}

		System.out.print(answer);
	}

	static int[] getDistances(int startNode) {		
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startNode] = 0;

		boolean[] isVisited = new boolean[N+1];

		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startNode, 0));
		while(!pq.isEmpty()) {
			Node current = pq.poll();

			if(isVisited[current.e]) {
				continue;
			}

			isVisited[current.e] = true;
			
			for(Node node : graph[current.e]) {
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
