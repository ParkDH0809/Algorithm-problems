import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        if(N % 5 == 0) {
            sb.append((N / 5) + "");
        }
        
        if(N % 5 != 0) {
            sb.append(calculate(N) + "");
        }
        System.out.print(sb);
    }
    
    public static int calculate(int N) {
        int n = 0;
        while(true) {
            N -= 3;
            n++;
            if(N % 5 == 0) {
                n += N / 5;
                return n;
            }
            
            if(N < 0) {
                return -1;
            }
        }
    }
}