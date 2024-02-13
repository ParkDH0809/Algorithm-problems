import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static int[] indegree;
	static List<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			indegree[B]++;
		}

		
		Queue<Integer> queue = new ArrayDeque<>();
		while(true) {
			for(int i = 1; i <= N; i++) {
				if(indegree[i] == 0) {
					queue.add(i);
					indegree[i] = -1;
				}
			}
			
			if(queue.isEmpty()) {
				break;
			}
			
			int current = queue.poll();
			for(int i : graph.get(current)) {
				indegree[i]--;
			}
			
			sb.append(current + " ");
		}
		
		System.out.println(sb);
	}

}
