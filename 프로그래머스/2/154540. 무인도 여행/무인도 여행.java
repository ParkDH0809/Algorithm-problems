import java.util.*;
class Solution {
    int sum;
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                sum = 0;
                method(maps, i, j, visited);
                if(sum != 0)
                    list.add(sum);
            }
        }
        if(list.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(x -> x).toArray();
    }
    
    void method(String[] maps, int x, int y, boolean[][] visited) {
        if(x < 0 || x >= maps.length || 
           y < 0 || y >= maps[0].length() || 
           visited[x][y] || maps[x].charAt(y) == 'X')
            return;
        
        visited[x][y] = true;
        
        sum += maps[x].charAt(y) - '0';
        method(maps, x - 1, y, visited);
        method(maps, x, y - 1, visited);
        method(maps, x + 1, y, visited);
        method(maps, x, y + 1, visited);
    }
}