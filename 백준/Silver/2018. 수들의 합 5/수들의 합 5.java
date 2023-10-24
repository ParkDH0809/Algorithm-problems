import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int f = 0, t = 0;
        int sum = 0;
        int answer = 0;
        while(true) {
            if(sum <= N) {
                if(sum == N)
                    answer++;
                t++;
                sum += t;
            } else {
                f++;
                sum -= f;
            }
            
            if(f == N) {
                break;
            }
        }
        bw.append(answer + "");
        bw.close();
    }
}