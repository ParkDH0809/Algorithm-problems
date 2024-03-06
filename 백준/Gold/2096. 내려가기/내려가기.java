import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] minDp = new int[N][3];
		int[][] maxDp = new int[N][3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n0 =Integer.parseInt(st.nextToken());
		int n1 =Integer.parseInt(st.nextToken());
		int n2 =Integer.parseInt(st.nextToken());
		minDp[0][0] = maxDp[0][0] = n0;
		minDp[0][1] = maxDp[0][1] = n1;
		minDp[0][2] = maxDp[0][2] = n2;
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			n0 = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + n0;
			maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + n0;
			
			minDp[i][1] = Math.min(minDp[i-1][0], Math.min(minDp[i-1][1], minDp[i-1][2])) + n1;
			maxDp[i][1] = Math.max(maxDp[i-1][0], Math.max(maxDp[i-1][1], maxDp[i-1][2])) + n1;
		
			minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + n2;
			maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + n2;			
		}
		
		sb.append(Math.max(maxDp[N-1][0], Math.max(maxDp[N-1][1], maxDp[N-1][2])));
		sb.append("\n");
		sb.append(Math.min(minDp[N-1][0], Math.min(minDp[N-1][1], minDp[N-1][2])));
		System.out.println(sb);
	}
	
}