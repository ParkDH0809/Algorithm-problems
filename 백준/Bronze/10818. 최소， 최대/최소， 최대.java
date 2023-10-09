import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int current;
        for(int i = 0; i < testCase; i++) {
            current = Integer.parseInt(st.nextToken());
            min = Math.min(min, current);
            max = Math.max(max, current);
        }
        
        bw.append(min + " " + max);
        bw.close();
    }
}