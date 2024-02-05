import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static boolean[] visited;
	static int[] arr;
	static int N, M;
	static int answer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = -1;
			arr = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			getAnswer(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void getAnswer(int sum, int count, int current) {
		if(sum > M) {
			return;
		}
		
		if(count == 2) {
			answer = Math.max(answer, sum);
			return;
		}
		
		if(current == N) {
			return;
		}
		
		getAnswer(sum, count, current+1);
		getAnswer(sum+arr[current], count+1, current+1);
	}
		
}