import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int n = 1;
        Stack<Integer> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            
            while(n <= input) {
                stack.push(n);
                sb.append("+\n");
                n++;
            }
            
            if(stack.peek() == input) {
                stack.pop();
                sb.append("-\n");
                continue;
            }

            if(n > input && stack.peek() != input) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}