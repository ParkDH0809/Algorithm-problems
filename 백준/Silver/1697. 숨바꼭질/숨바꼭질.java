import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.println("0");
            return;
        }

        int answer = 1;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[200001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        queue.add(N * 2);
        queue.add(N + 1);
        queue.add(N - 1);

        out: while(true) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int n = queue.poll();
                if(n < 0 || n > visited.length - 1 || answer > visited[n])
                    continue;
                else if(n == K)
                    break out;

                visited[n] = answer;
                queue.add(n * 2);
                queue.add(n + 1);
                queue.add(n - 1);
            }
            answer++;
        }

        System.out.println(answer);
    }
}