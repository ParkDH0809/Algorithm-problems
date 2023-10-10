import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        
        int sum = 1;
        int n = 1;
        while(true) {
            if(input <= sum) {
                bw.append(n + "");
                break;
            }
            sum += 6 * n;
            n++;
        }
        
        bw.close();
    }
}