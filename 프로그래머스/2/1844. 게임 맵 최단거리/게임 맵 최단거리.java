import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int mapsX = maps.length;
        int mapsY = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        boolean[][] visited = new boolean[mapsX][mapsY];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int answer = 1;
        while(true) {
            answer++;
            
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] currentPoint = queue.poll();
                
                for(int j = 0; j < 4; j++) {
                    int x = currentPoint[0] + dx[j];
                    int y = currentPoint[1] + dy[j];
                    
                    if(x < 0 || x >= mapsX || y < 0 || y >= mapsY || maps[x][y] == 0)
                        continue;
                    
                    if(x == mapsX - 1 && y == mapsY - 1)
                        return answer;
                    
                    if(visited[x][y])
                        continue;
                    else
                        visited[x][y] = true;
                        
                    queue.add(new int[]{x, y});
                }
            }
            
            if(queue.isEmpty())
                break;
        }
        
        return -1;
    }
}