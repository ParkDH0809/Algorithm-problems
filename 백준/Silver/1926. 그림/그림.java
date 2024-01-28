import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] == 1) {
                    count = 0;
                    checkBoard(i, j);
                    result.add(count);
                }
            }
        }
        if(result.size() == 0) {
            bw.append("0\n0");
        } else {
            Collections.sort(result);
            bw.append(result.size() + "\n");
            bw.append(result.get(result.size()-1) + "");
        }
        
        bw.close();
    }

    static void checkBoard(int x, int y) {

        visited[x][y] = true;
        count++;

        for(int dir = 0; dir < 4; dir++) {
            int xx = x + dx[dir];
            int yy = y + dy[dir];

            if(xx < 0 || xx == board.length || yy < 0 || yy == board[0].length || board[xx][yy] == 0 || visited[xx][yy]) {
                continue;
            }

            checkBoard(xx, yy);
        }

    }

}
