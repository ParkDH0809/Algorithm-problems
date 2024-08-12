import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int count = 1;
		int answer = 0;
		while (N-- > 0) {
			if (st.nextToken().equals("1")) {
				answer += count++;
			} else {
				count = 1;
			}
		}

		System.out.print(answer);
	}
}