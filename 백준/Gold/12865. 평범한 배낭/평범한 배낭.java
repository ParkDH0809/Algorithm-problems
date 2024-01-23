import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 1. 해당 물건을 배낭에 넣는 경우
		// 2. 해당 물건을 배낭에 넣지 않는 경우
		int[][] dp = new int[N+1][K+1];
		for(int i = 0; i < N+1; i++) {
			dp[i][0] = 0;			
		}
		
		for(int j = 0; j < K+1; j++) {
			dp[0][j] = 0;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < K+1; j++) {
				if(arr[i-1][0] <= j)  {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i-1][0]] + arr[i-1][1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
                
			}
            
		}
		
		bw.append(dp[N][K] + "");
		bw.flush();
		
	}
	
}
