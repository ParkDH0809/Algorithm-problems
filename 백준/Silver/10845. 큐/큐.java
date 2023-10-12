import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Queue<String> queue = new LinkedList<>();
       
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String back = "";
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push":
                    back = st.nextToken();
                    queue.add(back);
                    break;
                    
                case "pop":
                    if(queue.isEmpty()) {
                        bw.append("-1\n");
                    } else {
                        bw.append(queue.poll() + "\n");
                    }
                    break;
                    
                case "size":
                    bw.append(queue.size() + "\n");
                    break;

                case "empty":
                    if(queue.isEmpty()) {
                        bw.append("1\n");
                    } else {
                        bw.append("0\n");
                    }
                    break;
                
                case "front":
                    if(queue.isEmpty()) {
                        bw.append("-1\n");
                    } else {
                        bw.append(queue.peek() + "\n");
                    }
                    break;
                
                case "back": 
                    if(queue.isEmpty()) {
                        bw.append("-1\n");
                    } else {
                        bw.append(back + "\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}