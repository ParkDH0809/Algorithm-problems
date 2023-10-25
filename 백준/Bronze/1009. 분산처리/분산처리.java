import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a % 10 == 0) {
                bw.append("10\n");
                continue;
            }
            
            int sum = a % 10;
            for(int i = 1; i < b; i++) {
                sum = (sum * a) % 10;
            }
            bw.append(sum + "\n");
        }
        bw.close();
    }
}