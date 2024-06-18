import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tanghulu = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tanghulu[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(getAnswer(tanghulu));
	}

	static int getAnswer(int[] tanghulu) {

		// n1: 최근 과일, n2: 오래된 과일
		int n1 = 0;
		int n2 = 0;
		int n1Point = 0;
		int n2Point = 0;
		int max = 0;
		int length = 0;
		for (int i = 0; i < tanghulu.length; i++) {
			if (n1 == 0) {
				n1 = tanghulu[i];
				n1Point = i;
				length++;
				continue;
			}

			if (n2 == 0 && n1 != tanghulu[i]) {
				n2 = n1;
				n1 = tanghulu[i];
				n2Point = n1Point;
				n1Point = i;
				length++;
				continue;
			}

			if (n1 == tanghulu[i]) {
				length++;
				n1Point = i;
				continue;
			}

			if (n2 == tanghulu[i]) {
				n2 = n1;
				n1 = tanghulu[i];
				n2Point = n1Point;
				n1Point = i;
				length++;
				continue;
			}

			max = Math.max(max, length);
			length = i - n2Point;
			n2 = n1;
			n1 = tanghulu[i];
			n2Point = n1Point;
			n1Point = i;
		}

		return Math.max(max, length);
	}

}