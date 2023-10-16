import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                bw.append("0\n");
                continue;
            }
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            if(map.size() == 1) {
                bw.append(n + "\n");
            } else {
                long answer = 1;
                for(int i : map.values()) {
                    answer *= i + 1;
                }
                bw.append(answer - 1 + "\n");
            }
        }
        bw.close();
    }
}