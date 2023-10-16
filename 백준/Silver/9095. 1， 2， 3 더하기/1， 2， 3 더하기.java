import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for(int i = 3; i < 10; i++) {
            arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
        }
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int input = Integer.parseInt(br.readLine());
            bw.append(arr[input - 1] + "\n");
        }
        bw.close();
    }
}