import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][] graph = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
        
            graph[n1][n2] =graph[n2][n1] = true;
        }   
        
        boolean[] visited = new boolean[N+1];
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i, graph, visited);
                answer++;
            }
        }

        bw.append(answer + "");
        bw.flush();
    }

    static void dfs(int n, boolean[][] graph, boolean[] visited) {
        visited[n] = true;
        for(int i = 1; i < graph.length; i++)
            if(!visited[i] && graph[n][i])
                dfs(i, graph, visited);
    }
}