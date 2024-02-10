import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        int n = 1;
        while(n*n <= N) {
            dp[n*n] = 1;
            n++;
        }

        for(int i = 1 ; i <= N; i++) {
            if(dp[i] == 1) {
                continue;
            }

            dp[i] = Math.min(getNumber(i), dp[i-1] + 1);
        }

        System.out.println(dp[N]);
    }

    static int getNumber(int n) {
        int current = 1;
        int min = Integer.MAX_VALUE;
        while(current * current <= n) {
            min = Math.min(min, dp[n - current * current]);
            current++;
        }

        return min+1;
    }
    
}