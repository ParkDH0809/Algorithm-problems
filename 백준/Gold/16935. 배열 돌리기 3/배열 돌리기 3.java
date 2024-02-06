import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N;
	static int M;
	static int R;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			switch (st.nextToken()) {
			case "1":
				operation01();
				break;
			case "2":
				operation02();
				break;
			case "3":
				operation03();
				break;
			case "4":
				operation04();
				break;
			case "5":
				operation05();
				break;
			case "6":
				operation06();
				break;
			}
		}

		print();

	}

	// 상하 반전
	static void operation01() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[N - (i + 1)][j];
			}
		}
		arr = tmp;
	}

	// 좌우 반전
	static void operation02() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[i][M - (j + 1)];
			}
		}
		arr = tmp;
	}

	// 오른쪽으로 90도 회전
	static void operation03() {
		int[][] tmp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[N - (j + 1)][i];
			}
		}
		changeMN();
		arr = tmp;
	}

	// 왼쪽으로 90도 회전
	static void operation04() {
		int[][] tmp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[j][M - (i + 1)];
			}
		}
		changeMN();
		arr = tmp;
	}

	// 시계방향 그룹 이동
	static void operation05() {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {		
				tmp[i][j + M / 2] = arr[i][j];
				tmp[i][j] = arr[i + N / 2][j];
				tmp[i + N / 2][j] = arr[i + N / 2][j + M / 2];
				tmp[i + N / 2][j + M / 2] = arr[i][j + M / 2];
			}
		}
		arr = tmp;
	}

	// 반시계방향 그룹 이동
	static void operation06() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][j] = arr[i][j + M / 2];
				tmp[i + N / 2][j] = arr[i][j];
				tmp[i + N / 2][j + M / 2] = arr[i + N / 2][j];
				tmp[i][j + M / 2] = arr[i + N / 2][j + M / 2];
			}
		}
		arr = tmp;
	}

	static void changeMN() {
		int tmp = M;
		M = N;
		N = tmp;
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}