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
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            sb.append(N-K).append("\n");
            for(int i = N; i >= K; i--) {
                sb.append(i + " ");
            }
            System.out.println(sb);
            return;
        } 

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        Point[] visited = new Point[100001];
        for(int i = 0; i < 100001; i++) {
            visited[i] = new Point();
        }

        boolean flag = false;
        int time = 0;
        while(true) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                if(current < 0 || current > 100000 || visited[current].time != -1) {
                    continue;
                }

                visited[current].time = time;

                if(visited[K].time != -1) {
                    flag = true;
                    break;
                }

                if(current*2 < 100001 && visited[current*2].before == -1) {
                    queue.add(current * 2);
                    visited[current*2].before = current;
                }

                if(current+1 < 100001 && visited[current+1].before == -1) {
                    queue.add(current + 1);
                    visited[current+1].before = current;
                }
                if(current-1 > 0 && visited[current-1].before == -1) {
                    queue.add(current - 1);
                    visited[current-1].before = current;
                }
            }   

            if(flag) {
                break;
            }

            time++;
        }
        
        int current = K;
        List<Integer> list = new ArrayList<>();
        list.add(K);
        while(current != N) {
            current = visited[current].before;
            list.add(current);
        }
        
        sb.append(visited[K].time + "\n");
        for(int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb);
    }

}

class Point {
    int before;
    int time;

    Point() {
        this.before = -1;
        this.time = -1;
    }
}