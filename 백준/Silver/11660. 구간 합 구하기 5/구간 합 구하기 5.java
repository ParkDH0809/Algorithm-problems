import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][N + 1];
        for(int i = 0; i <= N; i++) {
            arr[0][i] = 0;
        }
            
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];
            }
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            int sum = 0;
            for(int i = y1 - 1; i < y2; i++) {
                sum += arr[i][x2] - arr[i][x1 - 1];
            }
            bw.append(sum + "\n");
        }
        bw.close();
    }
}