import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        
        
        while(true) {
            int n = max % min;
            max = min;
            min = n;
            
            if(min == 0) {
                break;
            }
        }
        
        bw.append(max + "\n" + (n1 * n2 / max));
        bw.close();
    }
}