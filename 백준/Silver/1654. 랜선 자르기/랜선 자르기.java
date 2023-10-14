import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[K];
        
        long max = 0;
        long min = 1;
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long mid = 0;
        while(min <= max) {
            mid = (max + min) / 2;
            long sum = 0;
            for(int i : arr) {
                sum += i / mid;
            }
            
            if(sum < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        bw.append((max+min)/2 + "");
        bw.close();
    }
}