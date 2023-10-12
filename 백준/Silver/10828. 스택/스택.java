import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<String> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push":
                    stack.push(st.nextToken());
                    break;

                case "top":
                    if(stack.isEmpty()) {
                        bw.append("-1\n");
                    } else {
                        bw.append(stack.peek() + "\n");
                    }
                    break;

                case "size":
                    bw.append(stack.size() + "\n");
                    break;

                case "empty":
                    if(stack.isEmpty()) {
                        bw.append("1\n");
                    } else {
                        bw.append("0\n");
                    }
                    break;
                    
                case "pop":
                    if(stack.isEmpty()) {
                        bw.append("-1\n");
                    } else {
                        bw.append(stack.pop() + "\n");
                    }
                    break;
            }
        }
        bw.close();
    }
}