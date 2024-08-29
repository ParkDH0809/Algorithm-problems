import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static int E;
    static Node[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new Node[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new Node();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].nodes.add(v2);
            graph[v2].nodes.add(v1);
        }

        if (isNotOneGraph()) {
            System.out.print("NO");
            return;
        }

        if (cantMakeLane()) {
            System.out.print("NO");
            return;
        }
        System.out.print("YES");
    }

    private static boolean isNotOneGraph() {
        boolean[] visited = new boolean[V+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;
            for (int v : graph[cur].nodes) {
                if (!visited[v]) {
                    queue.add(v);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if(!visited[i]) {
                return true;
            }
        }

        return false;
    }

    private static boolean cantMakeLane() {
        int obb = 0;
        for (int i = 1; i <= V; i++) {
            if (graph[i].nodes.size() % 2 != 0) {
                obb++;
            }
        }
        return obb != 0 && obb != 2;
    }

}

class Node {

    List<Integer> nodes;

    Node() {
        this.nodes = new ArrayList<>();
    }

}