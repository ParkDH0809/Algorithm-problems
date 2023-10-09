import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] max = new int[2];
        for(int i = 1; i <= 9; i++) {
            int current = Integer.parseInt(br.readLine());
            if(current > max[0]) {
                max[0] = current;
                max[1] = i;
            }
        }
        
        bw.append(max[0] + "\n" + max[1]);
        bw.close();
    }
}