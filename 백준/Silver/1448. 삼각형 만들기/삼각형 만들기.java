import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] straws = new Integer[N];
        for (int i = 0; i < N; i++) {
            straws[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(straws, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });

        for (int i = 0; i < N - 2; i++) {
            int n1 = straws[i];
            int n2 = straws[i + 1];
            int n3 = straws[i + 2];

            if (n1 < n2 + n3) {
                System.out.print(n1 + n2 + n3);
                return;
            }
        }

        System.out.print(-1);
    }

}