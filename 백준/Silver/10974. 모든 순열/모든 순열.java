import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		method(new int[input], new boolean[input], input, 0, sb);
		System.out.print(sb);
	}

	static void method(int[] arr, boolean[] selected, int number, int count, StringBuilder sb) {
		if (count == number) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < number; i++) {
			if (!selected[i]) {
				arr[count] = i + 1;
				selected[i] = true;
				method(arr, selected, number, count + 1, sb);
				selected[i] = false;
			}
		}
	}

}