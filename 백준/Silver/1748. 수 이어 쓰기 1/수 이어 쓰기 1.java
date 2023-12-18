import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int count = 1;
        int n = 10;
        for(int i = 1; i <= N; i++) {
            if(i % n == 0) {
                count += 1;
                n *= 10;
            }
            answer += count;
        }
        bw.append(answer + "");
        bw.flush();
    }
}