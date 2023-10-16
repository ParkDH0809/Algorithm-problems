import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static boolean[][] visited;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N+2][M+2];
        visited = new boolean[N+2][M+2];

        Arrays.fill(arr[0], 'X');
        Arrays.fill(arr[N+1], 'X');
        for(int i = 0; i <= N + 1; i++) {
            arr[i][0] = 'X';
            arr[i][M+1] = 'X';
        }
        
        int x = 0;
        int y = 0;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            for(int j = 1; j <= M; j++) {
                arr[i][j] = input.charAt(j - 1);
                if(arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        
        move(x, y);
        if(answer == 0) {
            bw.append("TT");
        } else {
            bw.append(answer + "");
        }
        bw.close();
    }
    
    public static void move(int x, int y) {
        if(visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        if(arr[x][y] == 'P') {
            answer++;
        }
        
        if(arr[x - 1][y] != 'X') {
            move(x - 1, y);
        }
        if(arr[x][y - 1] != 'X') {
            move(x, y - 1);
        }
        if(arr[x + 1][y] != 'X') {
            move(x + 1, y);
        }
        if(arr[x][y + 1] != 'X') {
            move( x, y + 1);
        }
    }
}