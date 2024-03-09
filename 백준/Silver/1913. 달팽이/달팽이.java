import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int r = 0; 
        int c = 0;

        int start = N * N;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int dir = 0;
        while(start > 0) {
            map[r][c] = start--;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr == N || nc == N || map[nr][nc] != 0) {
                dir = (dir+1) % 4;
            }

            r = r + dr[dir];
            c = c + dc[dir];
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int current = map[i][j];
                sb.append(current).append(" ");

                if(current == num) {
                    r = i+1;
                    c = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(r).append(" ").append(c);
        System.out.println(sb);
    }
}