import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            String input = br.readLine();
            boolean check = true;
            if(input.equals("0")) {
                break;
            }
            for(int i = 0; i < input.length() / 2; i++) {
                if(input.charAt(i) != input.charAt(input.length() - i - 1)) {
                    // bw.append("no\n");
                    check = false;
                    break;
                }
            
                if(i == input.length() / 2 - 1) {
                    // bw.append("yes\n");
                }
            }
            if(check) {
                bw.append("yes\n");
            } else {
                bw.append("no\n");
            }
        }
        
        bw.close();
    }
}