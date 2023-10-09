import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            
            if(result == 0)
                break;
            bw.append(result + "\n");
        }
        bw.close();
    }
}