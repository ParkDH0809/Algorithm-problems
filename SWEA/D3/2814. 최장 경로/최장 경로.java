import java.util.*;
import java.io.*;

class Solution {
	static int[][] graph;
	static boolean[] visited;
	static int answer;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new int[N][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[x-1][y-1] = graph[y-1][x-1] = 1;
			}
			
			answer = 0;
			for(int i = 0; i < N; i++) {
				visited = new boolean[N];
				visited[i] = true;
				method(i, 0);
			}
			
			answer++;
			bw.append("#" + test_case + " " + answer + "\n");
		}
        bw.close();
	}

	static void method(int cor, int sum) {
		for(int i = 0; i < graph[cor].length; i++) {
			if(visited[i]) {
				continue;
			}
			
			if(graph[cor][i] == 1) {
				visited[i] = true;
				method(i, sum + 1);
				visited[i] = false;
			}
		}
		 
		answer = Math.max(answer, sum);
	}
}