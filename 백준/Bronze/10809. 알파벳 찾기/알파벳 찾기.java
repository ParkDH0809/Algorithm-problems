import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        String string = br.readLine();
        for(int i = 0; i < string.length(); i++) {
            if(arr[string.charAt(i) - 'a'] == -1) {
                arr[string.charAt(i) - 'a'] = i;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            bw.append(arr[i] + " ");
        }
        bw.close();
    }
}