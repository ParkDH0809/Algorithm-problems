import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        
        if(sum == X) {
            System.out.print("Yes");
        } else {
            System.out.println("No");
        }
    }
}