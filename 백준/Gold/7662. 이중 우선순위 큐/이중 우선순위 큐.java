import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0) {
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
            PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder());
            
            int k = Integer.parseInt(br.readLine());
            int size = 0;
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());    
                if(st.nextToken().equals("I")) {
                    size++;

                    int input = Integer.parseInt(st.nextToken());
                    map.put(input, map.getOrDefault(input, 0) + 1);
                    ascQueue.offer(input);
                    descQueue.offer(input);
                } else {
                    size--;

                    if(size <= 0) {
                        ascQueue.clear();
                        descQueue.clear();
                        map.clear();
                        size = 0;
                        continue;
                    }

                    if(st.nextToken().equals("1")) {
                        int n = descQueue.poll();
                        map.put(n, map.get(n)-1);
                        if(map.get(n) == 0) {
                            map.remove(n);
                        }

                        while(!map.containsKey(descQueue.peek()) && !descQueue.isEmpty()) {
                            descQueue.poll();
                            continue;
                        }
                    } else {
                        int n = ascQueue.poll();
                        map.put(n, map.get(n)-1);
                        if(map.get(n) == 0) {
                            map.remove(n);
                        }

                        while(!map.containsKey(ascQueue.peek()) && !ascQueue.isEmpty()) {
                            ascQueue.poll();
                            continue;
                        }
                    }
                }
            }
            
            if(size == 0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(descQueue.poll()).append(" ").append(ascQueue.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}