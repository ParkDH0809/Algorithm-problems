import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        BigInteger bi = new BigInteger(String.valueOf("1"));
        
        for(int i = 1; i <= input; i++) {
            bi = bi.multiply(new BigInteger(String.valueOf(i)));
        }
        
        String s = bi.toString();
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != '0') {
                break;
            }
            result++;
        }
        bw.append(result + "");
        bw.close();
    }
}