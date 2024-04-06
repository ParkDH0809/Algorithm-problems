import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] edges;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        edges = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            edges[n2]++;
        }

        System.out.print(getAnswer());
    }

    static StringBuilder getAnswer() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(edges[i] == 0) {
                pq.add(i);
                visited[i] = true;
            }
        }

        StringBuilder sb  = new StringBuilder();
        while(!pq.isEmpty()) {
            int current = pq.poll();
            for(int i : graph.get(current)) {
                edges[i]--;
                if(edges[i] == 0) {
                    visited[i] = true;
                    pq.add(i);
                }
            }

            sb.append(current).append(" ");
        }
        return sb;
    }
}