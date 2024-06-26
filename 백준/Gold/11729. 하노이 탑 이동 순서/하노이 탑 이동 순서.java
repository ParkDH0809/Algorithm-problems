import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        hanoi(Integer.parseInt(br.readLine()), 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }


    static void hanoi(int N, int from, int temp, int to) {
        count++;

        if(N == 1) {
           sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(N-1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(N-1, temp, from, to);
    }
}