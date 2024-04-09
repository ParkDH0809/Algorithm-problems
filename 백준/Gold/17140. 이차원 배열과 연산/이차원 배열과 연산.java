import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int maxR;
	static int maxC;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		map = new int[100][100];
		maxC = 3;
		maxR = 3;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while (count <= 100) {
			if (map[r][c] == k) {
				System.out.print(count);
				return;
			}
			
			if (maxR >= maxC) {
				maxC = funcR();
			} else {
				maxR = funcC();
			}
			
			count++;
		}

		System.out.print(-1);
	}

	static int funcR() {
		int maxLength = 0;
		for (int r = 0; r < maxR; r++) {
			int[] number = new int[101];
			for (int c = 0; c < maxC; c++) {
				number[map[r][c]]++;
			}

			int count = 0;
			int minNumber = 1;
			while (count < 100 && minNumber < 100) {
				for (int i = 1; i < 101; i++) {
					if (number[i] == minNumber) {
						map[r][count] = i;
						map[r][count + 1] = minNumber;
						count += 2;
					}

					if (count >= 100) {
						break;
					}
				}
				minNumber++;
			}

			for(int c = count; c < 100; c++) {
				map[r][c] = 0;
			}
			
			maxLength = Math.max(count, maxLength);
		}
		return maxLength;
	}

	static int funcC() {
		int maxLength = 0;
		for (int c = 0; c < maxC; c++) {
			int[] number = new int[101];
			for (int r = 0; r < maxR; r++) {
				number[map[r][c]]++;
			}

			int count = 0;
			int minNumber = 1;
			while (count < 100 && minNumber < 100) {
				for (int i = 1; i < 101; i++) {
					if (number[i] == minNumber) {
						map[count][c] = i;
						map[count+1][c] = minNumber;
						count += 2;
					}

					if (count >= 100) {
						break;
					}
				}
				minNumber++;
			}

			for(int r = count; r < 100; r++) {
				map[r][c] = 0;
			}
			
			maxLength = Math.max(count, maxLength);
		}
		return maxLength;
	}
	
	static void print() {
		for(int r = 0; r < maxR; r++) {
			for(int c = 0; c < maxC; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}