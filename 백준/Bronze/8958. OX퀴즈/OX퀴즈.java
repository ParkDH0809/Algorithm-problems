import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            String string = br.readLine();
            
            int result = 0;
            int score = 0;
            for(char c : string.toCharArray()) {
                if(c == 'O') {
                    result += ++score;
                }
                if(c == 'X') {
                    score = 0;
                }
            }
            bw.append(result + "\n");
        }
        
        bw.close();
    }
}