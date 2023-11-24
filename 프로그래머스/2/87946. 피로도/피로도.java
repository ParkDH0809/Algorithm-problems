import java.util.*;

class Solution {
    ArrayList<int[]> list;
    public int solution(int k, int[][] dungeons) {
        list = new ArrayList<>();
        perm(new int[dungeons.length], dungeons.length, new boolean[dungeons.length], 0);
        
        int answer = 0;
        for(int[] order : list) {
            int fatigue = k;
            int sum = 0;
            for(int i : order) {
                if(fatigue < dungeons[i][0] || fatigue < dungeons[i][1])
                    break;
                fatigue -= dungeons[i][1];
                sum++;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    void perm(int[] result, int n, boolean[] visited, int count) {
        if(count == n) {
            list.add(result.clone());
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[count] = i;
                perm(result, n, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}