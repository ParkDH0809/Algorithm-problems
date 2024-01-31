import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            arr[i] += Integer.parseInt(st.nextToken()) + arr[i-1]; 
        }
        
        for(int n = 0; n < M; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.append(arr[j] - arr[i - 1] +"\n");
        }
        bw.close();
    }
}