import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] magnets;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		magnets = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				magnets[i][j] = input.charAt(j) - '0';
			}
		}

		int inputCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < inputCase; i++) {
			st = new StringTokenizer(br.readLine());
			int magnet = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			rotateMagnet(magnet, direction, checkRotatableMagnet(magnet));
		}
		
		System.out.println(getAnswer());
	}

	static boolean[] checkRotatableMagnet(int magnet) {
		boolean[] canRotate = new boolean[4];
		canRotate[magnet] = true;

		int currentMagnet = magnet;
		int leftMagnet = magnet - 1;
		while (leftMagnet >= 0 && magnets[currentMagnet][6] != magnets[leftMagnet][2]) {
			canRotate[leftMagnet] = true;
			currentMagnet = leftMagnet;
			leftMagnet--;
		}

		currentMagnet = magnet;
		int rightMagnet = magnet + 1;
		while (rightMagnet < 4 && magnets[currentMagnet][2] != magnets[rightMagnet][6]) {
			canRotate[rightMagnet] = true;
			currentMagnet = rightMagnet;
			rightMagnet++;
		}

		return canRotate;
	}

	static void rotateMagnet(int magnet, int direction, boolean[] canRotate) {
		if (magnet < 0 || magnet >= 4 || !canRotate[magnet]) {
			return;
		}

		canRotate[magnet] = false;
		if (direction == 1) {
			rotateRight(magnet);
		} else {
			rotateLeft(magnet);
		}

		int nextDirection = (direction == 1 ? -1 : 1);
		rotateMagnet(magnet + 1, nextDirection, canRotate);
		rotateMagnet(magnet - 1, nextDirection, canRotate);
	}

	static void rotateRight(int magnet) {
		int tmp = magnets[magnet][7];
		for (int i = 7; i > 0; i--) {
			magnets[magnet][i] = magnets[magnet][i - 1];
		}
		magnets[magnet][0] = tmp;
	}

	static void rotateLeft(int magnet) {
		int tmp = magnets[magnet][0];
		for (int i = 0; i < 7; i++) {
			magnets[magnet][i] = magnets[magnet][i + 1];
		}
		magnets[magnet][7] = tmp;
	}

	static int getAnswer() {
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			if (magnets[i][0] == 1) {
				answer += Math.pow(2, i);
			}
		}
		return answer;
	}
}