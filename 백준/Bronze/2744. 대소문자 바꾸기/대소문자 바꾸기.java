import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder(br.readLine());
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if('a' <= c && c <= 'z')
                sb.setCharAt(i, (char)(c - 32));
            else
                sb.setCharAt(i, (char)(c + 32));
        }
        bw.append(sb);
        bw.flush();
    }
};