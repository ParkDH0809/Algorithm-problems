import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            int answer = 0;
            String input = br.readLine();
            if(input.equals("#"))
                break;
            
            for(char c : input.toCharArray()) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                   c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                    answer++;
            }
            
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}