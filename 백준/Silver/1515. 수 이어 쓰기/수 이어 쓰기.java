import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int number = 1;
        int point = 0;

        out: while (point < input.length()) {
            String numberString = Integer.toString(number);
            for (int i = 0; i < numberString.length(); i++) {
                if (input.charAt(point) == numberString.charAt(i)) {
                    point++;

                    if (point == input.length()) {
                        break out;
                    }
                }
            }
            number++;
        }

        System.out.print(number);
    }

}