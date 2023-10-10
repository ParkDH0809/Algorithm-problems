import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        bw.append((factorial(N) / (factorial(N - K) * factorial(K))) + "");
        bw.close();
    }
    
    public static int factorial(int i) {
        if(i <= 1) return 1;
        return factorial(i - 1) * i;
    }
}