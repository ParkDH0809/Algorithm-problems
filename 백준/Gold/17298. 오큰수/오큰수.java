import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        int current = N - 1;
        while(current >= 0) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                if(stack.peek() > arr[current]) {
                    answer[current] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            
            if(stack.isEmpty()) {
                answer[current] = -1;
            }
            
            stack.push(arr[current]);
            current--;
        }

        for(int n : answer)
            bw.append(n + " ");

        bw.close();
    }
}