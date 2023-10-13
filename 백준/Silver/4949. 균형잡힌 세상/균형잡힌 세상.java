import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        out : while(true) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            if(s.equals(".")) {
                break;
            }
            try {
                for(char c : s.toCharArray()) {
                    if(c == '(' || c == '[') {
                        stack.push(c);
                    }
                
                    if(c == ')' && stack.pop() != '(') {
                        bw.append("no\n");
                        continue out;
                    }
                
                    if(c == ']' && stack.pop() != '[') {
                        bw.append("no\n");
                        continue out;
                    }
                }
            } catch (EmptyStackException e) {
                bw.append("no\n");
                continue;
            }
            
            if(stack.size() == 0) {
                bw.append("yes\n");
            } else {
                bw.append("no\n");
            }
        }
            
        bw.close();
    }
}