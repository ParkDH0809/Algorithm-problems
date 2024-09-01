import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int head = 0;
        int tail = N - 1;
        int headAnswer = 0;
        int tailAnswer = N - 1;

        while (head != tail) {
            int result = arr[head] + arr[tail];
            if (Math.abs(result) < min) {
                headAnswer = head;
                tailAnswer = tail;
                min = Math.abs(result);
            }

            if (result <= 0) {
                head++;
            } else {
                tail--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[headAnswer]).append(" ").append(arr[tailAnswer]);
        System.out.print(sb);
    }

}