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
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}

		int min = 10000000;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int current = find(i);
			if(min > current) {
				min = current;
				result = i;
			}
		}
		
		System.out.print(result);
	}

	static int find(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);

		boolean[] visited = new boolean[N + 1];
		visited[n] = true;
		
		int count = 0;
		int answer = 0;
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			while (size-- > 0) {
				int current = queue.poll();

				for (int i : graph[current]) {
					if (!visited[i]) {
						queue.add(i);
						visited[i] = true;
						answer += count;
					}
				}
			}

			count++;
		}

		return answer;

	}
}
