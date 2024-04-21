import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Homework> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        boolean[] isSelected = new boolean[1001];
        int score = 0;
        while (!pq.isEmpty()) {
            Homework hw = pq.poll();

            for (int i = hw.d; i >= 1; i--) {
                if(isSelected[i]) {
                    continue;
                }

                score += hw.w;
                isSelected[i] = true;
                break;
            }
        }

        System.out.print(score);
    }
}

class Homework implements Comparable<Homework> {

    int d;
    int w;

    Homework(int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Homework o) {
        return o.w - w;
    }

    @Override
    public String toString() {
        return d + " " + w;
    }
}