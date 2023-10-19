import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long[] arr = new long[100];
        arr[0] = arr[1] = arr[2] = 1;
        for(int i = 3; i < 100; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        
        int T = Integer.parseInt(br.readLine());
        while(T > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.append(arr[N - 1] + "\n");
            T--;
        }
        bw.close();
    }
}