import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int answer;

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int selectedNum = 0;
		boolean cupon = false;
		int[] selected = new int[d + 1];
		for (int i = 0; i < k; i++) {
			if (selected[arr[i]] == 0) {
				selectedNum++;
			}
			selected[arr[i]]++;
		}
		if (selected[c] == 0) {
			cupon = true;
			selectedNum++;
		}
		answer = selectedNum;

		// k와 N의 값이 같은 경우
		if (k == N) {
			System.out.println(answer);
			return;
		}

		// 반복
		int head = k;
		int tail = 0;
		while (tail != N) {
			if (selected[arr[tail]] > 0) {
				selected[arr[tail]]--;
				if (selected[arr[tail]] == 0) {
					selectedNum--;
				}
			}

			selected[arr[head]]++;
			if (selected[arr[head]] == 1) {
				selectedNum++;
			}

			if (cupon && selected[c] != 0) {
				cupon = !cupon;
				selectedNum--;
			} else if (!cupon && selected[c] == 0) {
				cupon = !cupon;
				selectedNum++;
			}

			answer = Math.max(answer, selectedNum);
			head = (head + 1) % N;
			tail = tail + 1;
		}

		System.out.println(answer);
	}

}