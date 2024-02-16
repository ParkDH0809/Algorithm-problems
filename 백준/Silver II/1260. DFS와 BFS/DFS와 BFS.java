import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
	
	static List<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i<= N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());	
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		sort();
		
		dfs(V, new boolean[graph.size()], sb);
		sb.append("\n");
		bfs(V, new boolean[graph.size()], sb);
		System.out.println(sb);
	}
	
	static void sort() {
		for(int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
	}
	
	static void dfs(int V, boolean[] visited, StringBuilder sb) {
		sb.append(V).append(" ");
		
		visited[V] = true;
		List<Integer> node = graph.get(V);
		for(int i = 0; i < node.size(); i++) {
			if(!visited[node.get(i)]) {
				dfs(node.get(i), visited, sb);
			}
		}
	}
	
	static void bfs(int V, boolean[] visited, StringBuilder sb) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		visited[V] = true;
		queue.add(V);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			List<Integer> node = graph.get(current);
			for(int i = 0; i < node.size(); i++) {
				if(!visited[node.get(i)]) {
					queue.add(node.get(i));
					visited[node.get(i)] = true;
				}
			}
			sb.append(current).append(" ");
		}
	}
}
