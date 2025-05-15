import java.io.*;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input;
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            sb.append(getMaxValue(input)).append('\n');
        }
        System.out.print(sb);
    }

    private static int getMaxValue(int size) throws IOException {
        boolean isFirst = true;
        int max = 0;
        int sum = 0;

        while (size-- > 0) {
            int current = Integer.parseInt(br.readLine());
            sum += current;

            if (max < sum || isFirst) {
                max = sum;
                isFirst = false;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}