import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    final static int BOARD_SIZE = 5;

    static char[][] numberBoard;
    static Set<String> values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if (S + K + H >= 100) {
            System.out.print("OK");
            return;
        }

        if (S > K) {
            if (K > H) {
                System.out.print("Hanyang");
            } else {
                System.out.print("Korea");
            }
        } else {
            if (S > H) {
                System.out.print("Hanyang");
            } else {
                System.out.print("Soongsil");
            }
        }
    }

}