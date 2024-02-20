import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
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
            sb.append(N-K).append("\n1");
            System.out.println(sb);
            return;
        } 

        HashMap<Integer, Point> map = new HashMap<>();
        for(int i = 0; i < 100001; i++) {
            map.put(i, new Point());
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        int time = 0;
        while(true) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                if(current < 0 ||current > 100000 
                || (map.get(current).time != 0 && time > map.get(current).time)) {
                    continue;
                }

                map.get(current).time = time;
                map.get(current).number++;

                queue.add(current * 2);
                queue.add(current + 1);
                queue.add(current - 1);
            }   
            time++;

            if(map.get(K).time != 0) {
                break;
            }
            
        }

        sb.append(map.get(K).time).append("\n").append(map.get(K).number);
        System.out.print(sb);
    }

}

class Point {
    int time;
    int number;

    Point() {
        this.time = 0;
        this.number = 0;
    }
}