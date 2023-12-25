import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        bw.append(method(N, r, c, 0) + "");
        bw.flush();
    }

    static int method(int N, int r, int c, int answer) {
        if(N == 0)
            return answer;
        
        int center = (int)Math.pow(2, N-1);
        int add = (int)Math.pow(4, N-1);

        if(r < center) {
            if(c < center) {
                return method(N-1, r, c, answer);
            } else {
                return method(N-1, r, c-center, answer + add);
            }
        } else {
            if(c < center) {   
                return method(N-1, r-center, c, answer + add * 2);
            } else {
                return method(N-1, r-center, c-center, answer + add * 3);
            }
        }
    }
}