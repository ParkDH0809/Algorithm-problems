import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashSet<String> set = new HashSet<>();
        
        int N = Integer.parseInt(br.readLine());
        while(N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()) {
                case "add":
                    set.add(st.nextToken());
                    break;
                case "check":
                    if(set.contains(st.nextToken())) 
                        bw.append("1\n");
                    else 
                        bw.append("0\n");
                    break;
                case "remove":
                    set.remove(st.nextToken());
                    break;
                case "toggle":
                    String token = st.nextToken();
                    if(set.contains(token)) 
                        set.remove(token);
                    else
                        set.add(token);
                    break;
                case "all":
                    for(int i = 1; i <= 20; i++) {
                        set.add(i + "");
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
            N--;
        }
        bw.close();
    }
}