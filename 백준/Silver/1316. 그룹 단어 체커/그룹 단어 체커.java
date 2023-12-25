import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while(N-- > 0) {
            HashSet<Character> set = new HashSet<>();
            String input = br.readLine();

            boolean check = true;
            char current = input.charAt(0);
            for(char c : input.toCharArray()) {
                if(current != c) {
                    if(set.contains(c)) {
                        check = !check;
                        break;
                    }
                    set.add(current);
                    current = c;
                }
            }

            if(check)
                answer++;
        }
        
        bw.append(answer + "");
        bw.flush();
    }
}