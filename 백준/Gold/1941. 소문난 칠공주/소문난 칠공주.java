import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<Point> sPoints;
    static List<Point> yPoints;
    static Point[] sResult;
    static Point[] yResult;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        sPoints = new ArrayList<>();
        yPoints = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            String input = br.readLine();
            for(int j = 0; j < 5; j++) {
                if(input.charAt(j) == 'Y') {
                    yPoints.add(new Point(i, j));
                } else {
                    sPoints.add(new Point(i, j));
                }
            }
        }

        for(int i = 4; i <= 7; i++) {
            if(sPoints.size() < i) {
                break;
            }
            sResult = new Point[i];
            yResult = new Point[7-i];
            combS(0, 0);
        }
        
        System.out.print(answer);
    }

    static void combS(int start, int count) {
        if(count == sResult.length) {
            combY(0, 0);
            return;
        }

        for(int i = start; i < sPoints.size(); i++) {
            sResult[count] = sPoints.get(i);
            combS(i+1, count+1);
        }
    }

    static void combY(int start, int count) {
        if(count == yResult.length) {
            if(isAnswer()) {
                answer++;
            }
            return;
        }

        for(int i = start; i < yPoints.size(); i++) {
            yResult[count] = yPoints.get(i);
            combY(i+1, count+1);
        }
    }

    static boolean isAnswer() {
        boolean[][] visited = new boolean[5][5];
        boolean[][] selected = new boolean[5][5];
        initVisited(selected, sResult);        
        initVisited(selected, yResult);        

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(sResult[0]);
        visited[sResult[0].r][sResult[0].c] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int dir = 0; dir < 4; dir++) {
                int nr = point.r + dr[dir];
                int nc = point.c + dc[dir];

                if(!isRange(nr, nc)) {
                    continue;
                }

                if(visited[nr][nc]) {
                    continue;
                }

                if(selected[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                }
            }

            count++;
        }

        if(count == 7) {
            return true;
        }
        return false;
    }

    static void initVisited(boolean[][] visited, Point[] points) {
        for(Point point : points) {
            visited[point.r][point.c] = true;
        }
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}

class Point {

    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return r + " " + c;
    }
}