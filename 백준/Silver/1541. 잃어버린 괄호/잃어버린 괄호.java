import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int answer = 0;
        boolean check = false;
        while(st.hasMoreTokens()) {
            int sum = 0;
            StringTokenizer sst = new StringTokenizer(st.nextToken(), "+");
            
            while(sst.hasMoreTokens()) {
                sum += Integer.parseInt(sst.nextToken());
            }
            
            if(check) {
                answer -= sum;
            } else {
                answer += sum;
                check = true;
            }
        }
        bw.append(answer + "");
        bw.close();
    }
}