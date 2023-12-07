import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] board = new String[N];
        
        for(int i = 0; i < N; i++)
            board[i] = br.readLine();
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int count = 2;
        while(true) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] point = queue.poll();
                
                for(int dir = 0; dir < 4; dir++) {
                    int x = point[0] + dx[dir];
                    int y = point[1] + dy[dir];
                
                    if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || board[x].charAt(y) == '0')
                        continue;
                    
                    if(x == N - 1 && y == M - 1) {
                        System.out.println(count);
                        return;
                    }
                    
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
            count++;
        }
    }
}