import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] ladder;
    static int N;
    static int M;
    static int H;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 세로선
        M = Integer.parseInt(st.nextToken());   // 가로선
        H = Integer.parseInt(st.nextToken());   // 각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수

        ladder = new int[H+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = b+1;
            ladder[a][b+1] = b;
        }
        
        for(int i = 0; i <= 3; i++) {
            getAnswer(0, i);
            if(flag) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    static void getAnswer(int count, int max) {
        if(flag) {
            return;
        }

        if(count == max) {
            if(isPossible()) {
                flag = true;
            }
            return;
        }

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if(ladder[i][j] == 0 && ladder[i][j+1] == 0) {
                    ladder[i][j] = j+1;
                    ladder[i][j+1] = j;
                    getAnswer(count+1, max);
                    ladder[i][j] = ladder[i][j+1] = 0;
                }
            }
            
        }
    }

    static boolean isPossible() {
        for(int i = 1; i <= N; i++) {
            int current = i;
            for(int h = 1; h <= H; h++) {
                if(ladder[h][current] != 0) {
                    current = ladder[h][current];
                }
            }
            if(i != current) {
                return false;
            }
        }
        return true;
    }
} 