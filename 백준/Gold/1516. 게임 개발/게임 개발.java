import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			nodes[i].id = i;
			nodes[i].value = value;
			
			while (true) {
				int before = Integer.parseInt(st.nextToken());
				if (before == -1) {
					break;
				}

				nodes[i].beforeNodes.add(before);
				nodes[before].afterNodes.add(i);
				nodes[i].in++;
			}
			
			
		}

		Queue<Node> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (nodes[i].in == 0) {
				queue.add(nodes[i]);
			}
		}

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i : node.afterNodes) {
				nodes[i].in--;
				if (nodes[i].in == 0) {
					queue.add(nodes[i]);
					int max = 0;
					for (int j : nodes[i].beforeNodes) {
						max = Math.max(max, nodes[j].value);
					}
					
					nodes[i].value += max;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(nodes[i].value).append("\n");
		}
		System.out.print(sb);
	}
}

class Node {

	int id;
	int value;
	int in;
	List<Integer> beforeNodes;
	List<Integer> afterNodes;

	Node() {
		beforeNodes = new ArrayList<>();
		afterNodes = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return id + ": " + value + " " + in;
	}
}