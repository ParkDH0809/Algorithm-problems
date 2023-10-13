import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            int current = Integer.parseInt(br.readLine());
            if(current != 0) {
                stack.push(current);
            }
            if(current == 0) {
                stack.pop();
            }
        }
        
        int answer = 0;
        for(int i : stack) {
            answer += i;
        }
        bw.append(answer + "");
        bw.close();
    }
}