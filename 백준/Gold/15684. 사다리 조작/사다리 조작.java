import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[N+1][H+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[b][a] = b+1;
            ladder[b+1][a] = b;
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
                if(ladder[j][i] == 0 && ladder[j+1][i] == 0) {
                    ladder[j][i] = j+1;
                    ladder[j+1][i] = j;
                    getAnswer(count+1, max);
                    ladder[j][i] = ladder[j+1][i] = 0;
                }
            }
            
        }
    }

    static boolean isPossible() {
        for(int i = 1; i <= N; i++) {
            int current = i;
            for(int h = 1; h <= H; h++) {
                if(ladder[current][h] != 0) {
                    current = ladder[current][h];
                }
            }
            if(i != current) {
                return false;
            }
        }
        return true;
    }
} 