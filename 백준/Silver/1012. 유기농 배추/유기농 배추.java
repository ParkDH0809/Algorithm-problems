import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] ground = new int[M + 2][N + 2];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ground[Integer.parseInt(st.nextToken()) + 1][Integer.parseInt(st.nextToken()) + 1] = 1;
            }
            
            int answer = 0;
            for(int i = 1; i < ground.length - 1; i++) {
                for(int j = 1; j < ground[0].length - 1; j++) {
                    if(ground[i][j] == 1) {
                        ground = changeNum(ground, i, j);
                        answer++;
                    }
                }
            }
            bw.append(answer + "\n");
        }
        bw.close();
    }
    
    public static int[][] changeNum(int[][] ground, int i, int j) {
        ground[i][j] = 0;
        if(ground[i-1][j] == 1) {
            changeNum(ground, i-1, j);
        }
        if(ground[i][j-1] == 1) {
            changeNum(ground, i, j-1);
        }
        if(ground[i+1][j] == 1) {
            changeNum(ground, i+1, j);
        }
        if(ground[i][j+1] == 1) {
            changeNum(ground, i, j+1);
        }
        return ground;
    }
}