import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			nodes[n1].nearNodes.add(nodes[n2]);
			nodes[n2].nearNodes.add(nodes[n1]);
		}

		initTree();
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			sb.append(find(nodes[n1], nodes[n2])).append("\n");
		}
		
		System.out.print(sb);
	}

	static void initTree() {
		Node root = nodes[1];
		root.level = 1;

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node parent = queue.pollFirst();
			for (Node child : parent.nearNodes) {
				if (parent.parent != null && child.value == parent.parent.value) {
					continue;
				}

				child.parent = parent;
				child.level = parent.level + 1;
				queue.addLast(child);
			}
		}
	}
	
	static int find(Node n1, Node n2) {
		while(true) {
			if(n1.value == n2.value) {
				return n1.value; 
			}
			
			if(n1.level >= n2.level) {
				n1 = n1.parent;
			} else {
				n2 = n2.parent;
			}
		}
	}

}

class Node {

	int value;
	int level;
	Node parent;
	List<Node> nearNodes;

	Node(int value) {
		nearNodes = new ArrayList<>();
		this.value = value;
	}

}