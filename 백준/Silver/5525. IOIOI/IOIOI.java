import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		int answer = 0;
		int current = 0;
		boolean iFlag = false;
		boolean oFlag = false;
		for (int i = 0; i < M; i++) {
			if (S.charAt(i) == 'I') {

				if (iFlag) {
					current = 0;
				}

				if (oFlag) {
					current++;
					oFlag = false;
				}

				iFlag = true;

			} else {
				if (oFlag) {
					current = 0;
					iFlag = false;
					oFlag = false;
				}

				if (iFlag) {
					iFlag = false;
					oFlag = true;
				}
			}

			if (current == N) {
				answer++;
				current--;
			}
		}

		System.out.println(answer);
	}
}