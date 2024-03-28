import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		SegmentTree segmentTree = new SegmentTree(N);
		segmentTree.init(1, 1, N, arr);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				segmentTree.change(1, 1, N, b, c - arr[b]);
				arr[b] = c;
			} else {
				sb.append(segmentTree.sum(1, 1, N, b, (int)c)).append("\n");
			}
		}
		System.out.println(sb);
	}
}

class SegmentTree {
	long[] tree;
	int treeSize;

	SegmentTree(int size) {
		treeSize = (int) Math.pow(2, Math.ceil((Math.log(size) / Math.log(2))) + 1);
		tree = new long[treeSize];
	}

	long init(int node, int left, int right, long[] arr) {
		if (left == right) {
			return tree[node] = arr[left];
		}

		int mid = (left + right) / 2;
		return tree[node] = init(node * 2, left, mid, arr) 
				+ init(node * 2 + 1, mid + 1, right, arr);
	}

	void change(int node, int left, int right, int changeNode, long value) {
		if (changeNode < left || right < changeNode) {
			return;
		}

		tree[node] += value;

		if (left != right) {
			int mid = (left + right) / 2;
			change(node * 2, left, mid, changeNode, value);
			change(node * 2 + 1, mid + 1, right, changeNode, value);
		}
	}

	long sum(int node, int left, int right, int startNode, int endNode) {
		if (left > endNode || right < startNode) {
			return 0;
		}

		if (startNode <= left && right <= endNode) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		return sum(node * 2, left, mid, startNode, endNode) 
				+ sum(node * 2 + 1, mid + 1, right, startNode, endNode);
	}
	
	void print() {
		System.out.println(Arrays.toString(tree));
	}
}