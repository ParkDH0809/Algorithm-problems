import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }

                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if('1' <= o1.charAt(i) && o1.charAt(i) <= '9') sum1 += o1.charAt(i) - '0';
                        if('1' <= o2.charAt(i) && o2.charAt(i) <= '9') sum2 += o2.charAt(i) - '0';
                    }

                    if(sum1 != sum2) {
                        return sum1 - sum2;
                    }

                    return o1.compareTo(o2);
                }
        );
        
        while (n-- > 0) {
            pq.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.print(sb);
    }

}