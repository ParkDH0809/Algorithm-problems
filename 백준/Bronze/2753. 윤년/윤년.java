import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        
        if(input % 4 == 0 && input % 100 != 0) {
            bw.append("1");
        } else if(input % 400 == 0) {
            bw.append("1");
        } else {
            bw.append("0");
        }
        bw.close();
    }
}