import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine(), " ");
            
            Queue<Integer> queue = new LinkedList<>();
            Integer[] arr = new Integer[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.valueOf(st.nextToken());
                queue.offer(arr[i]);
            }
            
            Arrays.sort(arr, Collections.reverseOrder());
            
            int pos = M;
            int n = 0;
            while(true) {
                int value = queue.poll();
                if(value == arr[n]) {
                    n++;
                    
                    if(M == 0) {
                        break;
                    }
                }
                
                if(value != arr[n]) {
                    queue.offer(value);
                }
                
                M--;
                if(M < 0) {
                    M = queue.size() - 1;
                }
            }
            
            bw.append(n + "\n");
        }
        bw.close();
    }
}