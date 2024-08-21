import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[x].children.add(y);
            nodes[y].parent = x;
        }

        System.out.print(getAnswer(n1, n2));
    }

    static int getAnswer(int n1, int n2) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n1);
        visited[n1] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.poll();

                if (nodes[current].parent == n2) {
                    return count;
                }

                if (!visited[nodes[current].parent]) {
                    queue.add(nodes[current].parent);
                    visited[nodes[current].parent] = true;
                }

                for (int i : nodes[current].children) {
                    if (i == n2) {
                        return count;
                    }

                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }

            count++;
        }

        return -1;
    }

}

class Node {

    int parent;
    List<Integer> children;

    Node() {
        this.children = new ArrayList<>();
    }

}