import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int head = 0;
        int tail = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while(!(head == N && sum < S)) {
            if(sum < S) {
                sum += arr[head++];
            } else {
                sum -= arr[tail++];
            }

            if(sum >= S) {
                answer = Math.min(answer, head - tail);
            }
        }

        if(answer == Integer.MAX_VALUE) {
            bw.append("0");
        } else {
            bw.append(String.valueOf(answer));
        }
        bw.flush();
    }
}