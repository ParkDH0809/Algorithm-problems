import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while(N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(priorityQueue.isEmpty()) {
                    bw.append("0\n");
                } else {
                    bw.append(priorityQueue.poll() + "\n");
                }
            } else {
                priorityQueue.add(input);
            }
        }
        bw.flush();
    }
}