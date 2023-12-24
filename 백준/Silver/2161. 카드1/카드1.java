import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            queue.add(i);

        while(true) {
            bw.append(queue.poll() + " ");
            
            if(queue.isEmpty())
                break;
                
            int current = queue.poll();
            queue.add(current);
        }

        bw.flush();
    }
}