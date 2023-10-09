import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            
            for(char c : s.toCharArray()) {
                bw.append(String.valueOf(c).repeat(n));
            }
            bw.newLine();
        }
        bw.close();
    }
}