import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        visited[0] = visited[1] = true;
        for(int i = 2; i < Math.sqrt(N + 1); i++) {
            if(visited[i]) {
                continue;
            }
            
            for(int j = i * i; j <= N; j += i) {
                visited[j] = true;
            }
        }
        
        for(int i = M; i <= N; i++) {
            if(!visited[i]) {
                bw.append(i + "\n");
            }
        }
        bw.close();
    }
}