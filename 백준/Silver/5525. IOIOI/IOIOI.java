import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        String string = "IO".repeat(N) + "I";
        
        int answer = 0;

        for(int i = 0; i <= M - string.length(); i++) {
            if(S.substring(i).startsWith(string))
                answer++;
        }

        bw.append(answer + "");
        bw.flush();
    }
}