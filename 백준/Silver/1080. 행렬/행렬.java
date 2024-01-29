import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static boolean[][] result;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = initMap(br);
        result = initMap(br);

        int answer = 0;
        for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < M-1; j++) {
                if(map[i-1][j-1] != result[i-1][j-1]) {
                    changeMap(i, j);
                    answer++;
                }
            }
        }

        if(checkMap()) {
            bw.append(String.valueOf(answer));
        } else {
            bw.append("-1");
        }
        bw.flush();
    }

    static boolean[][] initMap(BufferedReader br) throws IOException {
        boolean[][] map = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0;j < M; j++){
                map[i][j] = temp.charAt(j) - '0' != 0;
            }
        }
        return map;
    }

    static void changeMap(int n, int m) {
        for(int i = n-1; i <= n+1; i++) {
            for(int j = m-1; j <= m+1; j++) {
                map[i][j] = !map[i][j];
            }
        }
    }

    static boolean checkMap() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != result[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}