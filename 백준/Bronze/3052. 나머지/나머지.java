import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            set.add(Integer.parseInt(br.readLine()) % 42);
        }
        
        bw.append(set.size() + "");
        bw.close();
    }
}