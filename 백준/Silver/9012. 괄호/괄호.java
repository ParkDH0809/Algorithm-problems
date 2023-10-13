import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        out : for(int i = 0;i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            
            for(char c : input.toCharArray()) {
                try {
                    if(c == '(')
                        stack.push('(');
                    if(c == ')')
                        stack.pop();
                } catch (EmptyStackException e) {
                    bw.append("NO\n");
                    continue out;
                }
            }
            
            if(stack.size() == 0) {
                bw.append("YES\n");
            } else {
                bw.append("NO\n");
            }
        }
        
        bw.close();
    }
}