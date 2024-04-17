import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for(int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        while(!bag.isEmpty()) {
            int current = bag.poll();

            while(!pq.isEmpty() && pq.peek().M <= current) {
                max.add(pq.poll().V);
            }

            if(!max.isEmpty()) {
                answer += max.poll();
            }
            
            if(pq.isEmpty()) {
                break;
            }
        }

        while(!bag.isEmpty() && !max.isEmpty()) {
            answer += max.poll();
            bag.poll();
        }

        System.out.print(answer);
    }
}

class Jewel implements Comparable<Jewel> {

    int M;
    int V;
    
    Jewel(int M, int V) {
        this.M = M;
        this.V = V;
    }

    @Override
    public int compareTo(Jewel o) {
        return M - o.M;
    }

}