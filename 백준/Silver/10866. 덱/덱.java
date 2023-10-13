import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int N = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()) {
                case "push_front":
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back":
                    deque.addLast(st.nextToken());
                    break;
                    
                case "pop_front":
                    if(deque.size() == 0) {
                        bw.append("-1\n");
                    } else {
                        bw.append(deque.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if(deque.size() == 0) {
                        bw.append("-1\n");
                    } else {
                        bw.append(deque.pollLast() + "\n");
                    }
                    break;
                    
                case "size":
                    bw.append(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.size() == 0) {
                        bw.append("1\n");
                    } else {
                        bw.append("0\n");
                    }
                    break;
                
                case "front":
                    if(deque.size() == 0) {
                        bw.append("-1\n");
                    } else {
                        bw.append(deque.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if(deque.size() == 0) {
                        bw.append("-1\n");
                    } else {
                       bw.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}