class Solution {
    boolean check;
    
    public int[] solution(String[][] places) {
        int[] answer = {0, 0, 0, 0, 0};
        
        for(int i = 0; i < 5; i++) {
            check = true;
            
            for(int x = 0; x < 5; x++)
                for(int y = 0; y < 5; y++) 
                    if(places[i][x].charAt(y) == 'P')
                        checkAround(places[i], x, y, x, y, 0);
            
            if(check) 
                answer[i] = 1;
        }
        return answer;
    }
    
    void checkAround(String[] places, int baseX, int baseY, int x, int y, int count) {
        if(count == 2)
            return;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for(int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx < 0 || xx >= 5 || yy < 0 || yy >= 5 || (xx == baseX && yy == baseY))
                continue;
            
            if(places[xx].charAt(yy) == 'P') {
                check = false;
                return;
            }
            
            if(places[xx].charAt(yy) == 'X') {
                continue;
            }
            
            checkAround(places, baseX, baseY, xx, yy, count + 1);
        }
    }
}