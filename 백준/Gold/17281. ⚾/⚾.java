import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] player;
	static int answer;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		player = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// getAnswer
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		do {
			playGame(arr);
		} while (nextPermutation(arr));
		System.out.print(answer);
	}

	static void playGame(int[] arr) {
		int[] base = new int[4];
		int[] order = getOrder(arr);
		int currentPlayer = 0;
		int currentInning = 0;
		int outCount = 0;
		int score = 0;
		while (currentInning < N) {
			int ball = player[currentInning][order[currentPlayer]];
			currentPlayer = (currentPlayer + 1) % 9;
			
			if (ball == 0) {
				outCount++;
                if (outCount == 3) {
                    currentInning++;
                    outCount = 0;
                    Arrays.fill(base, 0);
                }
                continue;
			}

			// 진출한 주자 진루
			for (int i = 0; i < 4; i++) {
				if (base[i] != 0) {
					base[i] += ball;
				}
			}

			// 타자 진루
			for (int i = 0; i < 4; i++) {
				if (base[i] == 0) {
					base[i] = ball;
					break;
				}
			}

			// 득점
			for (int i = 0; i < 4; i++) {
				if (base[i] >= 4) {
					base[i] = 0;
					score++;
				}
			}
		}

		answer = Math.max(answer, score);
	}

	static int[] getOrder(int[] arr) {
		// 1 2 3 0 4 5 6 7 8
		int[] order = new int[9];
		for (int i = 0; i < 3; i++) {
			order[i] = arr[i];
		}
		order[3] = 0;
		for (int i = 3; i < 8; i++) {
			order[i + 1] = arr[i];
		}
		return order;
	}

	static boolean nextPermutation(int[] arr) {
		int N = 8;
		int i = N - 1;
		while (i > 0 && arr[i - 1] > arr[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (arr[i - 1] > arr[j]) {
			j--;
		}

		swap(arr, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}