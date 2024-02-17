import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<List<Integer>> degree = new ArrayList<>();
		List<List<Integer>> indegree = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			degree.add(new ArrayList<>());
			indegree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			degree.get(A).add(B);
			indegree.get(B).add(A);
		}
		
		sb.append(getNumber(indegree, X)).append(" ").append((N+1)-getNumber(degree, X));
		System.out.println(sb);
	}
	
	static int getNumber(List<List<Integer>> graph, int X) {
		boolean[] visited = new boolean[graph.size()];		
		visited[X] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(X);
		
		int count = 0;	
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i : graph.get(current)) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
			count++;
		}
		return count;
	}

}