import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int result = 
            Integer.parseInt(br.readLine()) * 
            Integer.parseInt(br.readLine()) * 
            Integer.parseInt(br.readLine());
        
        int arr[] = new int[10];
        for(char c : String.valueOf(result).toCharArray()) {
            arr[c - '0']++;
        }
        
        for(int i : arr) {
            bw.append(i + "\n");
        }
        bw.close();
    }
}