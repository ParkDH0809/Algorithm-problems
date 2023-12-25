import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        boolean[] visited = new boolean[N+1];
        dfs(V, graph, visited, bw);

        Arrays.fill(visited, false);
        bw.newLine();
        bfs(V, graph, visited, bw);

        bw.flush();
    }

    static void dfs(int V, boolean[][] graph, boolean[] visited, BufferedWriter bw) throws IOException{
        visited[V] = true;
        bw.append(V + " ");
        for(int i = 1; i < graph.length; i++) 
            if(!visited[i] && graph[V][i]) 
                dfs(i, graph, visited, bw);
    }

    static void bfs(int V, boolean[][] graph, boolean[] visited, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while(!queue.isEmpty()) {
            int n = queue.poll();

            if(!visited[n]) {
                visited[n] = true;
                bw.append(n + " ");
            }

            for(int i = 1; i < graph.length; i++) 
                if(!visited[i] && graph[n][i]) 
                    queue.add(i);
        }
    }
}