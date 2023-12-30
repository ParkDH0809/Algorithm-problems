import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++)
                arr[i][j] = input.charAt(j) - '0';
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int count = 0;
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(arr[x][y] == 1) {
                    answer.add(method(arr, x, y, N, 1));
                    count++;
                }
            }
        }

        Collections.sort(answer);
        bw.append(count + "\n");
        for(int n : answer) {
            bw.append(n + "\n");
        }
        bw.flush();
    }

    static int method(int[][] arr, int x, int y, int N, int count) {
        arr[x][y] = 2;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx < 0 || xx >= N || yy < 0 || yy >= N || arr[xx][yy] != 1)
                continue;

            count = method(arr, xx, yy, N, count + 1);
        }

        return count;
    }
}