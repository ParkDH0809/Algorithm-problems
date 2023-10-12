import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            bw.append(binary(arr, Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.close();
    }
    
    public static int binary(int[] arr, int N) {
        int start = 0;
        int end = arr.length - 1;
        
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(N == arr[mid]) {
                result = 1;
                break;
            }
            
            if(N < arr[mid]) {
                end = mid - 1;
                continue;
            }
            
            if(N > arr[mid]) {
                start = mid + 1;
                continue;
            }
        }
        return result;
    }
}