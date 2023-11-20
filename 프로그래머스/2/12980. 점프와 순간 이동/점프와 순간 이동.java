import java.util.*;

public class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int n) {
        method(n, 0);
        return answer;
    }
    
    void method(int n, int count) {
        if (n == 1) {
            answer = Math.min(answer, count + 1);
            return;
        } else if (n <= 0) {
            return;
        }
        
        if (n % 2 == 0)
            method(n / 2, count);
        else 
            method((n - 1) / 2, count + 1);
    }
}