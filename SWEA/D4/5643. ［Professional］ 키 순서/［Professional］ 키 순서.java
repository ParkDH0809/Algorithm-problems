import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] bigNumber;
	static int[] smallNumber;
	static boolean[][] bigGraph;
	static boolean[][] smallGraph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());

			bigNumber = new int[N + 1];
			smallNumber = new int[N + 1];

			bigGraph = new boolean[N + 1][N + 1];
			smallGraph = new boolean[N + 1][N + 1];
			
			int M = Integer.parseInt(br.readLine());
			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				bigGraph[n1][n2] = true;
				smallGraph[n2][n1] = true;
			}

			for (int i = 1; i <= N; i++) {
				find(i, bigGraph, bigNumber);
				find(i, smallGraph, smallNumber);
			}

			sb.append("#").append(testCase).append(" ").append(getAnswer()).append("\n");
		}
		System.out.print(sb);
	}

	static void find(int input, boolean[][] graph, int[] number) {
		int count = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(input);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (visited[i]) {
					continue;
				}

				if (graph[current][i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
			count++;
		}

		number[input] = count-1;
	}

	static int getAnswer() {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (bigNumber[i] + smallNumber[i] == N - 1) {
				count++;
			}
		}
		return count;
	}
}
