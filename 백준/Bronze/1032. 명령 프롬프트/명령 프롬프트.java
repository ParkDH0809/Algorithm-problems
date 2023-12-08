import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder input = new StringBuilder(br.readLine());
        while(--N > 0) {
            String s = br.readLine();
            for(int i = 0; i < input.length(); i++)
                if(s.charAt(i) != input.charAt(i))
                    input.setCharAt(i, '?');
        }
        System.out.println(input);
    }
}