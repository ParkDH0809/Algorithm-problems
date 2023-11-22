class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int result = method(i, j, picture[i][j], picture, visited);
                if(result != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, result);
                    numberOfArea++;
                }
            }
        }
        
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    
    int method(int x, int y, int color, int[][] picture, boolean[][] visited) {
        if(x < 0 || x >= picture.length || y < 0 || y >= picture[0].length || 
           visited[x][y] || picture[x][y] == 0 || picture[x][y] != color)
            return 0;
        
        visited[x][y] = true;
        int sum = 1;
        sum += method(x + 1, y, color, picture, visited);
        sum += method(x - 1, y, color, picture, visited);
        sum += method(x, y + 1, color, picture, visited);
        sum += method(x, y - 1, color, picture, visited);
        return sum;
    }
}