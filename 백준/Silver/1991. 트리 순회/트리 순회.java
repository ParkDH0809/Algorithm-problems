import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node((char) ('A' + i));
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';

			if (left > 0) {
				nodes[parent].left = nodes[left];
			}

			if (right > 0) {
				nodes[parent].right = nodes[right];
			}
		}

		preorder(nodes[0]);
		System.out.println();
		inorder(nodes[0]);
		System.out.println();
		postorder(nodes[0]);
	}

	static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.nodeName);
			preorder(root.left);
			preorder(root.right);
		}
	}

	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.nodeName);
			inorder(root.right);
		}
	}

	static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.nodeName);
		}
	}

}

class Node {

	char nodeName;
	Node right;
	Node left;

	Node(char nodeName) {
		this.nodeName = nodeName;
	}

}