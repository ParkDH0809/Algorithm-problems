import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		int number = 0;
		for (int i = 3; i >= 1; i--) {
			input = br.readLine();
			if (!input.endsWith("z")) {
				number = Integer.parseInt(input) + i;
				break;
			}
		}

		if (number % 3 == 0) {
			if (number % 5 == 0) {
				System.out.print("FizzBuzz");
			} else {
				System.out.print("Fizz");
			}
		} else {
			if (number % 5 == 0) {
				System.out.print("Buzz");
			} else {
				System.out.print(number);
			}
		}
	}
}
