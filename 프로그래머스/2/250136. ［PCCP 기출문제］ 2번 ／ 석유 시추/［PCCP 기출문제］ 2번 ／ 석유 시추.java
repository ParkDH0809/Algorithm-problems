import java.util.*;
import java.io.*;

class Solution {
    
    int maxR;
    int maxC;
    Map<Integer, Integer> oilGroups;
    
    public int solution(int[][] land) {
        maxR = land.length;
        maxC = land[0].length;
        oilGroups = new HashMap<>();
        
        unionLand(land);
        return getMaxOilNumber(land);
    }
    
    void unionLand(int[][] land) {
        boolean[][] visited = new boolean[maxR][maxC];
        int oilGroupNumber = 1;
        for (int r = 0; r < maxR; r++) {
            for (int c = 0; c < maxC; c++) {
                if(visited[r][c]) {
                    continue;
                }
                
                if(land[r][c] == 0) {
                    continue;
                }
                
                union(land, visited, new Point(r, c), oilGroupNumber++);
            }
        }
    }
    
    void union(int[][] land, boolean[][] visited, Point point, int oilGroupNumber) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        Queue<Point> points = new ArrayDeque<>();
        points.add(point);
        visited[point.r][point.c] = true;
        int count = 0;
        while (!points.isEmpty()) {
            Point current = points.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = current.r + dr[dir];
                int nc = current.c + dc[dir];
                
                if (!isRange(nr, nc)) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }
                
                if(land[nr][nc] == 0) {
                    continue;
                }
                
                points.add(new Point(nr, nc));
                visited[nr][nc] = true;
            }
            land[current.r][current.c] = oilGroupNumber;
            count++;
        }
        
        oilGroups.put(oilGroupNumber, count);
    }
    
    int getMaxOilNumber(int[][] land) {
        int max = 0;
        for (int c = 0; c < maxC; c++) {
            Set<Integer> selectedOilGroups = new HashSet<>();
            for (int r = 0; r < maxR; r++) {
                if (land[r][c] != 0) {
                    selectedOilGroups.add(land[r][c]);
                }
            }
            
            int sum = 0;
            for (int groupNumber : selectedOilGroups) {
                sum += oilGroups.get(groupNumber);
            }
            
            max = Math.max(max, sum);
        }
        return max;
    }
    
    boolean isRange(int r, int c) {
        return r >= 0 && r < maxR && c >= 0 && c < maxC;
    }
    
}

class Point {
    
    int r;
    int c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
}