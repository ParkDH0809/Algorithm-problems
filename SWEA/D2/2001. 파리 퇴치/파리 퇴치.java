import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N+1][N+1];
            Arrays.fill(map[0], 0);
            for(int i = 0; i < N+1; i++) {
                map[i][0] = 0;
            }

            for(int i = 1; i < N+1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j < N+1; j++) {
                    map[i][j] = map[i-1][j] + map[i][j-1] + Integer.parseInt(st.nextToken()) - map[i-1][j-1];
                }
            }

            int answer = 0;
            for(int i = M; i < N+1; i++) {
                for(int j = M; j < N+1; j++) {
                    answer = Math.max(answer, map[i][j] - map[i][j-M] - map[i-M][j] + map[i-M][j-M]);
                }
            }
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

}