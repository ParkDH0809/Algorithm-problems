import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        //memoization
        int[] memory = new int[y + 1];
        Arrays.fill(memory, Integer.MAX_VALUE);
        
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        
        //solve
        int current = x;
        int answer = 0;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                current = queue.poll();
                if(current == y) 
                    return answer;

                if(current > y) 
                    continue;

                if(memory[current] > answer)
                    memory[current] = answer;
                else
                    continue;

                queue.offer(current * 3);
                queue.offer(current * 2);
                queue.offer(current + n);
            }
            answer++;
        }
        
        return -1;
    }
}
