class Solution {
    public int solution(int n) {
        //1과 2의 조합
        int answer = 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        
        return dp[n - 1];
    }
}
