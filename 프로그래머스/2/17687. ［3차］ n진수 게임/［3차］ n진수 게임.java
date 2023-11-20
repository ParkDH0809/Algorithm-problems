import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder((n * m) + 1);
        StringBuilder answer = new StringBuilder(t + 1);
        for(int i = 0; i <= t * m; i++) 
            sb.append(Integer.toString(i, n));

        for(int i = 0; i < t; i++) 
            answer.append(sb.charAt((p - 1) + (i * m)));
        
        return answer.toString().toUpperCase();
    }
}