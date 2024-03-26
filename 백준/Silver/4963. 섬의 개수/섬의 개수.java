import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[h][w];
            int count = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 0 || visited[i][j]) {
                        continue;
                    }

                    visit(i, j, map, visited);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void visit(int r, int c, int[][] map, boolean[][] visited) {
        visited[r][c] = true;
        int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};

        for(int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nr == map.length || nc < 0 || nc == map[0].length) {
                continue;
            }

            if(map[nr][nc] == 0) {
                continue;
            }

            if(visited[nr][nc]) {
                continue;
            }
            
            visit(nr, nc, map, visited);
        }
    }
}