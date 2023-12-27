import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[301];
        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i = 3; i <= N; i++)
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        
        bw.append(dp[N] + "");
        bw.flush();
    }
}