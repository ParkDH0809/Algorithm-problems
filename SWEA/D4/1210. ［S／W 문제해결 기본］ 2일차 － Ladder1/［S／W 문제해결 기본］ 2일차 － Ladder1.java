import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			br.readLine();
			
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bw.append("#" + testCase + " " + getAnswer(getPoint()) + "\n");
		}
		bw.close();
	}

	static int getPoint() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if (map[99][i] == 2) {
				count = i;
				break;
			}
		}
		return count;
	}

	static int getAnswer(int point) {
		int height = 99;
		while (height > 0) {
			if (point != 99 && map[height][point + 1] == 1) {
				point = moveRight(height, point);
			} else if (point != 0 && map[height][point - 1] == 1) {
				point = moveLeft(height, point);
			}
			height--;
		}
		return point;
	}

	static int moveRight(int height, int point) {
		while (point + 1 != 100 && map[height][point + 1] != 0) {
			point++;
		}
		return point;
	}

	static int moveLeft(int height, int point) {
		while (point - 1 != -1 && map[height][point - 1] != 0) {
			point--;
		}
		return point;
	}
}