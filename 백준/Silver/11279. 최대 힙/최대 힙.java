import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            
            if(input == 0) {
                if(queue.size() != 0)
                    bw.append(queue.poll() + "\n");
                else
                    bw.append("0\n");
            } else {
                queue.add(input);
            }
        }
        
        bw.flush();
    }
}