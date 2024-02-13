import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		List<ArrayList<Integer>> graph = new ArrayList<>();
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
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
				indegree[i] = -1;
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i : graph.get(current)) {
				indegree[i]--;
				
				if(indegree[i] == 0) {
					queue.add(i);
				}
			}
			
			sb.append(current + " ");
		}
		
		System.out.println(sb);
	}

}
