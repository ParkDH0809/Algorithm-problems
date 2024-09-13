import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getAnswer());
    }

    static int getAnswer() {
        int[][] score = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                score[i][j] = Math.max(score[i][j-1], score[i-1][j]);

                if (map[i][j] == score[i][j-1] % 3) {
                    score[i][j] = Math.max(score[i][j], score[i][j-1] + 1);
                }

                if(map[i][j] == score[i-1][j] % 3) {
                    score[i][j] = Math.max(score[i][j], score[i-1][j] + 1);
                }
            }
        }
        return score[N][N];
    }

}