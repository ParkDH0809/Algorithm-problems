import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == -1 && n2 == -1) {
                break;
            }

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int min = 100;
        Queue<Integer> result = new ArrayDeque<>();
        for (int current = 1; current <= N; current++) {

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(current);

            boolean[] selected = new boolean[N + 1];
            selected[current] = true;

            int score = 0;
            int count = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int number = queue.poll();
                    for (int i : graph[number]) {
                        if (!selected[i]) {
                            selected[i] = true;
                            queue.add(i);
                            count++;
                        }
                    }
                }

                score++;
                if (count == N) {
                    break;
                }
            }

            if (min > score) {
                result.clear();
                result.add(current);
                min = score;
            } else if (min == score) {
                result.add(current);
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(result.size()).append("\n");
        while(!result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }
        System.out.print(sb);
    }
}