import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] team;
	static int[][] arr;
	static boolean isAnswer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			team = new int[6][3];
			isAnswer = false;

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					team[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			arr = new int[15][2];
			int size = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					arr[size][0] = i;
					arr[size][1] = j;
					size++;
				}
			}

//		System.out.println(Arrays.deepToString(arr));

			getAnswer(0);

			if (isAnswer) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}

	static void getAnswer(int count) {

		if (count == 15) {
			if (checkResult()) {
				isAnswer = true;
			}
			return;
		}

		team[arr[count][0]][0]--;
		team[arr[count][1]][2]--;
		getAnswer(count + 1);
		team[arr[count][0]][0]++;
		team[arr[count][1]][2]++;

		team[arr[count][0]][1]--;
		team[arr[count][1]][1]--;
		getAnswer(count + 1);
		team[arr[count][0]][1]++;
		team[arr[count][1]][1]++;

		team[arr[count][0]][2]--;
		team[arr[count][1]][0]--;
		getAnswer(count + 1);
		team[arr[count][0]][2]++;
		team[arr[count][1]][0]++;

	}

	static boolean checkResult() {
		for (int[] a : team) {
			for (int i : a) {
				if (i != 0) {
					return false;
				}
			}
		}
		return true;
	}
}