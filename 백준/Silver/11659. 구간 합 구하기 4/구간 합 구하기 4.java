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
        arr[0] = 0;
        arr[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i <= N; i++) {
            arr[i] += Integer.parseInt(st.nextToken()) + arr[i-1]; 
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.append(arr[j] - arr[i - 1] +"\n");
        }
        bw.close();
    }
}