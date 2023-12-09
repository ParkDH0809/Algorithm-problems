import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String input = br.readLine();
            bw.append(input.charAt(0)).append(input.charAt(input.length() - 1));
            bw.newLine();
        }
        bw.flush();
    }
}