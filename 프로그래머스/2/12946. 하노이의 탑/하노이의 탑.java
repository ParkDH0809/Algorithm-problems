import java.util.*;

class Solution {
    ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);        
        return getAnswer();
    }
    
    void hanoi(int n, int from, int pass, int to) {
        if(n == 0)
            return;
        
        hanoi(n-1, from, to, pass);
        list.add(new int[]{from, to});
        hanoi(n-1, pass, from, to);
    }
    
    int[][] getAnswer() {
        int[][] answer = new int[list.size()][];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);
        return answer;
    }
}