import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < cards.length; i++) {
            list.add(method(cards, visited, i));
        }
            
        if(list.size() == 1) {
            return list.get(0);
        } else {
            Collections.sort(list, Collections.reverseOrder());
            return list.get(0) * list.get(1);
        }
    }
    
    int method(int[] cards, boolean[] visited, int n) {
        int count = 0;
        while(true) {
            if(visited[n]) {
                break;
            }
            
            visited[n] = true;
            n = cards[n] - 1;
            count++;
        }
        
        return count;
    }
}