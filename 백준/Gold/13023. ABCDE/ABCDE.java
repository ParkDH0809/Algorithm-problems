import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Integer>> graph;
	static int N;
	static boolean isCompleted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		for (int i = 0; i < N; i++) {
			if(isCompleted) {
				break;
			}
			getAnswer(i, 0, new boolean[N]);
		}
		
		if(isCompleted) {
			System.out.print("1");
		} else {
			System.out.print("0");
		}
	}

	static void getAnswer(int current, int count, boolean[] visited) {
		if(count == 5) {
			isCompleted = true;
			return;
		}
		
		if(isCompleted) {
			return;
		}
		
		for(int i = 0; i < graph.get(current).size(); i++) {
			if(!visited[graph.get(current).get(i)]) {
				visited[graph.get(current).get(i)] = true;
				getAnswer(graph.get(current).get(i), count+1, visited);
				visited[graph.get(current).get(i)] = false;
			}
		}
	}
}