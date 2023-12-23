import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int startX = 0;
        int startY = 0;
        int[][] arr = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    startX = i;
                    startY = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        int[][] answer = new int[n][m];    
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                if(x < 0 || x >= n || y < 0 || y >= m)
                    continue;

                if(visited[x][y] || arr[x][y] == 0)
                    continue;

                answer[x][y] = answer[current[0]][current[1]] + 1;
                visited[x][y] = true;
            
                queue.add(new int[]{x, y});
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visited[i][j])
                    answer[i][j] = -1;
            }
        }

        answer[startX][startY] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.append(answer[i][j] + " ");
            }
            bw.newLine();
        }
        
        bw.flush();
    }
}