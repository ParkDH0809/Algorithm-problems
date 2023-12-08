import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(calculate(M).divide(calculate(M - N).multiply(calculate(N)))).append("\n");
        }
        System.out.println(sb);
    }
    
    static BigInteger calculate(int n) {
        BigInteger sum = new BigInteger("1");
        for(int i = 2; i <= n; i++) 
            sum = sum.multiply(new BigInteger(i + ""));
        return sum;
    }
}