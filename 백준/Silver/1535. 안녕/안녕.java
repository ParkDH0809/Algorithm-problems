import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int N;
    static int answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[2][N];

        StringTokenizer st;
        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        getAnswer(0, 0, 0);
        System.out.println(answer);
    }

    static void getAnswer(int HPSum, int happySum, int count) {
        if(HPSum >= 100) {
            return; 
        }

        if(count == N) {
            answer = Math.max(answer, happySum);
            return;
        }
        
        getAnswer(HPSum, happySum, count+1);
        getAnswer(HPSum+arr[0][count], happySum+arr[1][count], count+1);
    }
}
