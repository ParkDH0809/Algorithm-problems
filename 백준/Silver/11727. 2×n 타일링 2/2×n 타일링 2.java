import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[1001];
        int N = Integer.parseInt(br.readLine());
        
        arr[1] = 1;
        arr[2] = 3;
        
        for(int i = 3; i <= N; i++) 
            arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10007;
        
        bw.append(arr[N] + "");
        bw.flush();
    }
}