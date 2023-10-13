import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        
        int n = 0;
        int value = 665;
        while(n != input) {
            value++;
            if(String.valueOf(value).contains("666")) {
                n++;
            }
            
        }
        
        bw.append(value + "");
        bw.close();
    }
}