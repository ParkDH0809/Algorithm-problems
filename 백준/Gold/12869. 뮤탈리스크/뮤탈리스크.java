import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hp = new int[3];
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(hp, initDp()));
    }

    private static int[][][] initDp() {
        int[][][] dp = new int[61][61][61];
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return dp;
    }

    private static int bfs(int[] hp, int[][][] dp) {
        int[][] cases = {{1, 3, 9}, {3, 1, 9}, {1, 9, 3}, {3, 9, 1}, {9, 1, 3}, {9, 3, 1}};

        dp[hp[0]][hp[1]][hp[2]] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {hp[0], hp[1], hp[2]});

        int count = 1;
        while (true) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] currentCase : cases) {
                    int x = cur[0] - currentCase[0] < 0 ? 0 : cur[0] - currentCase[0];
                    int y = cur[1] - currentCase[1] < 0 ? 0 : cur[1] - currentCase[1];
                    int z = cur[2] - currentCase[2] < 0 ? 0 : cur[2] - currentCase[2];

                    if(dp[x][y][z] > count) {
                        dp[x][y][z] = count;
                        q.add(new int[] {x, y, z});
                    }
                }

                if(dp[0][0][0] != Integer.MAX_VALUE) {
                    return dp[0][0][0];
                }
            }
            count++;
        }
    }

}