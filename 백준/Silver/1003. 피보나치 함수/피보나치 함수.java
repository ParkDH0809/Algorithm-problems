import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited = new boolean[41];
    static int[][] value = new int[41][3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            int[] arr = fibo(input);
            bw.append(arr[0] + " " + arr[1] + "\n");
        }
        bw.close();
    }
    
    public static int[] fibo(int n) {
        if(visited[n]) {
            return value[n];
        }
        
        visited[n] = true;
        if(n == 0) {
            value[n][0]++;
            value[n][2] = 0;
            return value[n];
        } else if(n == 1) {
            value[n][1]++;
            value[n][2] = 1;
            return value[n];
        }
            
        value[n][2] = fibo(n - 1)[2] + fibo(n - 2)[2];
        value[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        value[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
        return value[n];
    }
}