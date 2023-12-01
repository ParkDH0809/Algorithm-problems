import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] farm = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                farm[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(method(farm));
    }

    static int method(int[][] farm) {
        Queue<int[]> queue = new LinkedList<>();
        int count = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(farm[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int currentQueueSize = 0; currentQueueSize < size; currentQueueSize++) {
                int[] currentPoint = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int x = currentPoint[0] + dx[i];
                    int y = currentPoint[1] + dy[i];

                    if(x < 0 || y < 0 || x >= N || y >= M || farm[x][y] == 1 || farm[x][y] == -1)
                        continue;

                    farm[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
            count++;
        }

        return getResult(farm, count);
    }

    static int getResult(int[][] farm, int count) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M ;j++) {
                if(farm[i][j] == 0)
                    return -1;
            }
        }
        return count;
    }
}