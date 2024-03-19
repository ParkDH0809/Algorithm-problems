import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				graph[r][c] = st.nextToken().equals("1") ? true : false;
			}
		}
		
		int[][] answer = new int[N][N];
		for(int r = 0; r < N; r++) {
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(r);
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				for(int c = 0; c < N; c++) {
					if(graph[current][c] && answer[r][c] == 0) {
						answer[r][c] = 1;
						queue.add(c);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				sb.append(answer[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}