import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] graph;
	static int[] weight;
	static int N;
	static int answer;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		answer = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());
		graph = new boolean[N + 1][N + 1];

		weight = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		for (int node = 1; node <= N; node++) {
			st = new StringTokenizer(br.readLine());
			int numberOfLinkedNode = Integer.parseInt(st.nextToken());
			for (int n = 0; n < numberOfLinkedNode; n++) {
				graph[node][Integer.parseInt(st.nextToken())] = true;
			}
		}

		makeSubset(new boolean[N], 0, 0);
		
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		System.out.println(answer);
	}

	static void makeSubset(boolean[] visited, int count, int numberOfTrue) {
		if (visited[0]) {
			return;
		}

		if (count == N) {
			getAnswer(visited, numberOfTrue);
			return;
		}

		visited[count] = true;
		makeSubset(visited, count + 1, numberOfTrue + 1);
		visited[count] = false;
		makeSubset(visited, count + 1, numberOfTrue);
	}

	static void getAnswer(boolean[] visited, int numberOfTrue) {
		if (numberOfTrue == 0) {
			return;
		}

		int[] firstSubset = new int[numberOfTrue];
		int[] secondSubset = new int[N - numberOfTrue];

		int firstSubsetCount = 0;
		int secondSubsetCount = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				firstSubset[firstSubsetCount++] = i + 1;
			} else {
				secondSubset[secondSubsetCount++] = i + 1;
			}
		}

		if (isPossible(firstSubset) && isPossible(secondSubset)) {
			answer = Math.min(answer, 
					Math.abs(calculateResult(firstSubset) - calculateResult(secondSubset)));
		}
	}

	static boolean isPossible(int[] nodes) {
		boolean[] visited = new boolean[N+1];
		dfs(nodes, visited, nodes[0]);

		for(int i : nodes) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}

	static void dfs(int[] nodes, boolean[] visited, int node) {
		visited[node] = true;
		for(int i : nodes) {
			if(graph[node][i] && !visited[i]) {
				dfs(nodes, visited, i);
			}
		}
	}
	
	static int calculateResult(int[] nodes) {
		int sum = 0;
		for(int i : nodes) {
			sum += weight[i];
		}
		return sum;
	}

}