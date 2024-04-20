import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static int count;
    static Point[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Point[R][C];

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = new Point(input.charAt(c) - '0');
            }
        }

        int answer = 0;
        for (int i = 1; i < 10; i++) {
            boolean[][] visited = new boolean[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c].isDead) {
                        continue;
                    }

                    if (visited[r][c]) {
                        continue;
                    }

                    if (map[r][c].value != i) {
                        continue;
                    }

                    count = 0;
                    if (find(i, r, c, visited)) {
                        answer += count;
                    }
                }
            }
            // System.out.println(i);
            // print();
        }

        System.out.print(answer);
    }

    static boolean find(int height, int r, int c, boolean[][] visited) {        
        visited[r][c] = true;
        boolean flag = true;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (!isRange(nr, nc)) {
                map[r][c].isDead = true;
                return false;
            }

            if (map[nr][nc].isDead) {
                map[r][c].isDead = true;
                return false;
            }

            if (visited[nr][nc]) {
                continue;
            }

            if (map[nr][nc].value > height) {
                continue;
            }

            if (!find(height, nr, nc, visited)) {
                flag = false;
            }
        }

        if (!flag) {
            map[r][c].isDead = true;
            return false;
        }

        map[r][c].value++;
        count++;
        return flag;
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static void print() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c].isDead + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Point {

    int value;
    boolean isDead;

    Point(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }

}