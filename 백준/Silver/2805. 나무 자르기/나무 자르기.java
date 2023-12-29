import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int min = 0;
        while(min < max) {
            long sum = 0;
            int mid = (max + min) / 2;

            for(int i = 0; i < N; i++) {
                if(arr[i] > mid)
                    sum += arr[i] - mid;
            }

            if(sum < M)
                max = mid;
            else
                min = mid + 1;
            
        }

        bw.append(max - 1 + "");
        bw.flush();
    }
}