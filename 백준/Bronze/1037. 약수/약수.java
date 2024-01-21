import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            bw.append((int)Math.pow(Integer.parseInt(br.readLine()), 2) + "");
        } else {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while(N-- > 0) {
                int current = Integer.parseInt(st.nextToken());
                min = Math.min(min, current);
                max = Math.max(max, current);
            }
            bw.append(min * max + "");
        }
        bw.flush();
    }
}