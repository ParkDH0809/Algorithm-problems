import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[][] graph = new boolean[N+1][N+1];
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        boolean[] visited = new boolean[N+1];
        dfs(1, graph, visited);

        int answer = 0;
        for (boolean b : visited) {
            if(b)
                answer++;
        }
        bw.append(answer - 1 + "");
        bw.flush();
    }

    static void dfs(int n, boolean[][] graph, boolean[] visited) {
        visited[n] = true;
        for(int i = 1; i < graph.length; i++) {
            if(graph[n][i] && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }
}