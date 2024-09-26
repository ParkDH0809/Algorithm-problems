import java.util.*;

import java.io.*;

public class Main {

    static final int LOTTO_COUNT = 6;

    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        String input = "";
        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);

            numbers = new int[Integer.parseInt(st.nextToken())];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            getAnswer(new int[LOTTO_COUNT], 0, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void getAnswer(int[] answer, int start, int count) {
        if (count == LOTTO_COUNT) {
            addString(answer);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            answer[count] = numbers[i];
            getAnswer(answer, i + 1, count + 1);
        }
    }

    private static void addString(int[] answer) {
        for (int i = 0; i < LOTTO_COUNT; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append("\n");
    }
}