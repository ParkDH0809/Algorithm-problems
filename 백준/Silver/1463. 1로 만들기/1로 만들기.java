import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Integer.parseInt(br.readLine()));
        boolean[] visited = new boolean[queue.peek() + 1];
        int count = 0;
        while(true) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int n = queue.poll();
                
                if(n == 1) {
                    System.out.println(count);
                    return;
                }
                    
                if(visited[n])
                    continue;
                
                visited[n] = true;
                
                if(n % 3 == 0)
                    queue.add(n / 3);
                if(n % 2 == 0)
                    queue.add(n / 2);
                queue.add(n - 1);
            }
            count++;
        }
    }
}