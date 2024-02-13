import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] delay = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] indegree = new int[N];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken())-1;
                int Y = Integer.parseInt(st.nextToken())-1;
                graph.get(X).add(Y);
                indegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine())-1;
            int[] result = new int[N];

            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < N; i++) {
                if(indegree[i] == 0) {
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()) {
                int current = queue.poll();
                result[current] += delay[current];

                for(int i : graph.get(current)) {
                    indegree[i]--;
                    result[i] = Math.max(result[i], result[current]);
                    if(indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }

            sb.append(result[W] + "\n");
        }

        System.out.println(sb);
    }

}
