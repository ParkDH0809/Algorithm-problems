import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine().toLowerCase();
        int[] count = new int[26];
        for(char c : input.toCharArray()) {
            count[c - 'a']++;
        }
        
        int max = 0;
        int resultAlphabet = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                resultAlphabet = -1;
            }

            if(count[i] > max) {
                max = count[i];
                resultAlphabet = i;
            }
        }
        
        if(resultAlphabet == -1) {
            bw.append("?");
        }
        
        if(resultAlphabet != -1) {
            bw.append((char)(resultAlphabet + 'A') + "");
        }
        
        bw.close();
    }
}