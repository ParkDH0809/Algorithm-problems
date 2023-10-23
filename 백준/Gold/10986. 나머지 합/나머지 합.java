import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N+1];
        arr[0] = 0;
        
        long[] remainder = new long[M];
        long answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = (arr[i-1] + Integer.parseInt(st.nextToken())) % M;
            if(arr[i] == 0) 
                answer++;
            remainder[(int)arr[i]]++;
        }
        
        for(int i = 0; i < M; i++) {
            if(remainder[i] > 1)
                answer += (remainder[i] * (remainder[i] - 1) / 2);
        }
        bw.append(answer + "");
        bw.close();
    }
} 