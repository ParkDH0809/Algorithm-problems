import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        boolean check = false;
        for(int i = 0; i <= input.length() / 2; i++) {
            if(input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                check = true;
                break;
            }
        }
        
        if(check)
            bw.append("0");
        else
            bw.append("1");
        bw.flush();
    }
}