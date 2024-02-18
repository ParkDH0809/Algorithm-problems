import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println("0");
            return;
        }
        
        Integer[] input = new Integer[N-1];
        for(int i = 0; i < N-1; i++) {
            input[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(input, (o1, o2) -> o2 - o1);
        
        int answer = 0;
        while(input[0] >= dasom) {
            input[0]--;
            dasom++;
            answer++;
            Arrays.sort(input, (o1, o2) -> o2 - o1);
        }

        System.out.println(answer);
    }
}