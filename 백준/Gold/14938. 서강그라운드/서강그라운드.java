import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int r;
	static int[] items;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		items = new int[n+1];
		graph = new ArrayList[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}

		int[][] nodeInfos = new int[r][3];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			nodeInfos[i][0] = Integer.parseInt(st.nextToken());
			nodeInfos[i][1] = Integer.parseInt(st.nextToken());
			nodeInfos[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nodeInfos, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for(int i = 0; i < r; i++) {
			graph[nodeInfos[i][0]].add(new Node(nodeInfos[i][1], nodeInfos[i][2]));
			graph[nodeInfos[i][1]].add(new Node(nodeInfos[i][0], nodeInfos[i][2]));
		}

		System.out.print(getAnswer());
	}

	static int getAnswer() {
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(getItems(i), max);	
		}
		return max;
	}

	static int getItems(int start) {
		boolean[] visited = new boolean[n+1];
		visited[start] = true;

		Queue<Movement> pq = new PriorityQueue<>();
		pq.add(new Movement(start, 0));

		while(!pq.isEmpty()) {
			Movement movement = pq.poll();
			for(Node node : graph[movement.currentNode]) {
				// if(visited[node.to]) {
				// 	continue;
				// }

				if(m < movement.moveLength + node.weight) {
					continue;
				}

				visited[node.to] = true;
				pq.add(new Movement(node.to, movement.moveLength + node.weight));
			}
		}

		int numberOfItems = 0;
		for(int i = 1; i <= n; i++) {
			if(visited[i]) {
				numberOfItems += items[i];
			}
		}
		// System.out.println(Arrays.toString(visited));
		return numberOfItems;
	}
}

class Movement implements Comparable<Movement> {

	int currentNode;
	int moveLength;	

	Movement(int currentNode, int moveLength) {
		this.currentNode = currentNode;
		this.moveLength = moveLength;
	}

	@Override
	public int compareTo(Movement o) {
		return moveLength - o.moveLength;
	}

}

class Node {

	int to;
	int weight;

	Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

}