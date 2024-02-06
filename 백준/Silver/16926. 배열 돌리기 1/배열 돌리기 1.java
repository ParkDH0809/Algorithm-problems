import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int N;
	static int M;
	static int R;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < Math.min(N, M)/2; i++) {
			turnArr(i);
		}

		for(int[] result : arr) {
			for(int i : result) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void turnArr(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		addQueue(queue, n);
		turnQueue(queue);
		changeArr(queue, n);
	}
	
	static void addQueue(Queue<Integer> queue, int n) {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int dir =0;
		
		int r = n;
		int c = n;
		int count = 0;
		int max = 2*(N-n*2) + 2*(M-n*2) - 4;
		while(count != max) {
			
			int rr = r + dr[dir];
			int cc = c + dc[dir];
			
			if(rr < n || rr >= N-n || cc < n || cc >= M-n) {
				dir++;
				continue;
			}
			
			queue.add(arr[r][c]);
			count++;
			r = rr;
			c = cc;
		}
		
	}
	
	
	static void turnQueue(Queue<Integer> queue) {
		int count = 0;
		while(count != R) {
			queue.offer(queue.poll());
			count++;
		}
	}
	
	
	static void changeArr(Queue<Integer> queue, int n) {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int dir =0;
		
		int r = n;
		int c = n;
		while(!queue.isEmpty()) {
			int rr = r + dr[dir];
			int cc = c + dc[dir];
			
			if(rr < n || rr >= N-n || cc < n || cc >= M-n) {
				dir++;
				continue;
			}
			
			arr[r][c] = queue.poll();
			r = rr;
			c = cc;
		}
		
	}
	
}