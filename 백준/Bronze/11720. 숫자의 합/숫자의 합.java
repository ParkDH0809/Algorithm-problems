import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        br.readLine();
        String[] s = br.readLine().split("");
        
        int result = 0;
        for(int i = 0; i < s.length; i++)
            result += Integer.parseInt(s[i]);
        
        
        bw.append(result + "");
        bw.close();
    }
}