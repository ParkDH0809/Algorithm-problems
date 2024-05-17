import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n1 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n1 += Integer.parseInt(st.nextToken());
        n1 += Integer.parseInt(st.nextToken());
        n1 += Integer.parseInt(st.nextToken());
        n1 += Integer.parseInt(st.nextToken());
        
        int n2 = 0;
        st = new StringTokenizer(br.readLine());
        n2 += Integer.parseInt(st.nextToken());
        n2 += Integer.parseInt(st.nextToken());
        n2 += Integer.parseInt(st.nextToken());
        n2 += Integer.parseInt(st.nextToken());
        
        System.out.print(Math.max(n1 ,n2));
    }
}