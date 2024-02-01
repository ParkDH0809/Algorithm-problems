import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		answer = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		getAnswer(1, 0, 0);
		sb.append(answer);
		System.out.println(sb);
	}

	static void getAnswer(int sin, int ssun, int count) {
		if (count == arr.length) {
			if(sin != 1 && ssun != 0) {
				answer = Math.min(answer, Math.abs(sin - ssun));
			}
			return;
		}

		getAnswer(sin * arr[count][0], ssun + arr[count][1], count + 1);
		getAnswer(sin, ssun, count + 1);
	}
}