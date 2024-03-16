import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[101];
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            if(arr[current]) {
                answer++;
            } else {
                arr[current] = true;
            }
        }

        System.out.println(answer);
    }
}