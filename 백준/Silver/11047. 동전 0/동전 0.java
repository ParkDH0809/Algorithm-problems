import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int result = 0; 
        int i = N - 1;
        int answer = 0;
        while(result != K) {
            if(arr[i] + result <= K) {
                result += arr[i];
                answer++;
            } else {
                i--;
            }
        }
        bw.append(answer + "");
        bw.close();
    }
}
