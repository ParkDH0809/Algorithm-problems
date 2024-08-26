import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] arr = new BigInteger[251];
        arr[0] = new BigInteger("1");
        arr[1] = new BigInteger("1");
        arr[2] = new BigInteger("3");
        for (int i = 3; i <= 250; i++) {
            arr[i] = arr[i - 2].multiply(new BigInteger("2")).add(arr[i - 1]);
        }

        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            sb.append(arr[Integer.parseInt(input)]).append("\n");
        }

        System.out.print(sb);
    }

}