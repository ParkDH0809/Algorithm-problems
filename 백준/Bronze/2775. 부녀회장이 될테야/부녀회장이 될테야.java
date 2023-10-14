import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] answer = new int[15][15];
        for(int i = 0; i < 15; i++) {
            answer[0][i] = i;
            answer[i][0] = 0;
        }
        
        for(int i = 1; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                answer[i][j] = answer[i][j-1] + answer[i-1][j];
            }
        }
        
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.append(answer[k][n] + "\n");
        }
        bw.close();
    }
}