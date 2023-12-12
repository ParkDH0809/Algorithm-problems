import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }
        
        int solved = 0;
        String answer = "";
        for(String book : map.keySet()) {
            int n = map.get(book);
            if(solved < n) {
                answer = book;
                solved = n;
            } else if(solved == n) {
                if(answer.compareTo(book) > 0)
                    answer = book;
            }
        }
        bw.append(answer);
        bw.flush();
    }
}