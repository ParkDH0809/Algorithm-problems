import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node();
		}

		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int current = Integer.parseInt(st.nextToken());
			if (current == -1) {
				root = i;
			} else {
				nodes[current].child.add(nodes[i]);
			}
		}

		int removeNode = Integer.parseInt(br.readLine());
		if(root == removeNode) {
			System.out.print(0);
			return;
		}
		
		nodes[removeNode].isRemoved = true;
		System.out.print(getAnswer(root, nodes));
	}

	static int getAnswer(int root, Node[] nodes) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(nodes[root]);

		int answer = 0;
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.isRemoved) {
				continue;
			}

			if (current.child.isEmpty()) {
				answer++;
			} else if(current.child.size() == 1 && current.child.get(0).isRemoved) {
				answer++;
			} else {
				for (Node node : current.child) {
					queue.add(node);
				}
			}
		}

		return answer;
	}
}

class Node {

	List<Node> child;
	boolean isRemoved;

	Node() {
		child = new ArrayList<>();
	}

}