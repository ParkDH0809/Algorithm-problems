import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        bw.append("<");
        while(true) {
            if(queue.size() == 1) {
                bw.append(queue.poll() + ">");
                break;
            }
            
            for(int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            bw.append(queue.poll() + ", ");
        }
        
        bw.close();
    }
}