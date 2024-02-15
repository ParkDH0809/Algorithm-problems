import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] startPoint;
	static int[][] point;
	static int[] endPoint;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			startPoint = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			endPoint = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			point = new int[N][2];
			for (int i = 0; i < N; i++) {
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}

			int[] numbers = new int[N];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = i;
			}
			answer = Integer.MAX_VALUE;
			
			do {
				getAnswer(numbers);
			} while (nextPermutation(numbers));

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static boolean nextPermutation(int[] numbers) {
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}
        
		int j = N - 1;
		while (numbers[i-1] >= numbers[j]) {
			j--;
		}

		swap(i-1, j, numbers);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--, numbers);
		}

		return true;
	}

	static void swap(int i, int j, int[] numbers) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	static void getAnswer(int[] numbers) {
		int sum = 0;
		int x = startPoint[0];
		int y = startPoint[1];
		for (int i = 0; i < numbers.length; i++) {
			int nx = point[numbers[i]][0];
			int ny = point[numbers[i]][1];

			sum += Math.abs(x - nx) + Math.abs(y - ny);
			x = nx;
			y = ny;
		}
		sum += Math.abs(x - endPoint[0]) + Math.abs(y - endPoint[1]);
		answer = Math.min(sum, answer);
	}

}