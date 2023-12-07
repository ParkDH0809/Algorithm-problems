class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        for(String s : Integer.toString(n, k).split("0")) {
            if(s.length() == 0 || s.equals("1"))
                continue;
            
            if(isPrime(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }
    
    boolean isPrime(long n) {
        for(int i = 2; i <= (int)Math.sqrt(n); i++) 
            if(n % i == 0)
                return false;
        return true;
    }
}