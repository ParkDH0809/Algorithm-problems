import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            
            int Y = N % H;
            int X;
            if(Y == 0) {
                X = N / H;
                bw.append(String.format("%d%02d\n", H, X));
            }
            
            if(Y != 0) {
                X = N / H + 1;
                bw.append(String.format("%d%02d\n", Y, X));
            }
            
        }
        bw.close();
    }
}