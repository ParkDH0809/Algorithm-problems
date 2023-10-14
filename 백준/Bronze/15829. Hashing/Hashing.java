import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        br.readLine();
        String input = br.readLine();
        
        long sum = 0;
        long pow = 1;
        for(int i = 0; i < input.length(); i++) {
            sum += (input.charAt(i) - 'a' + 1) * pow;
            pow = pow * 31 % 1234567891L;
        }
        bw.append(sum % 1234567891L + "");
        bw.close();
    }
}