import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        
        int head = 0;
        int tail = n-1;
        int answer = 0;
        while(head < tail) {
            int current = arr[head] + arr[tail];
            if(current < x) {
                head++;
            } else if (current > x) {
                tail--;
            } else {
                answer++;
                head++;
                tail--;
            }
        }
        System.out.println(answer);
    }
}