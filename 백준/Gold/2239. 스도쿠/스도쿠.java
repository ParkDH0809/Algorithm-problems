import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int zeroNumber;
	static boolean isFinished;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = input.charAt(j) - '0';
				if(board[i][j] == 0) {
					zeroNumber++;
				}
			}
		}
		
		backTrack(0);

	}

	static void backTrack(int current) {
		if(current == 81) {
			print();
			isFinished = true;
			return;
		}
		
		int r = current / 9;
		int c = current % 9;
		
		if(board[r][c] != 0) {
			backTrack(current + 1);
			return;
		}
		
		for(int number = 1; number <= 9; number++) {
			if(isFinished) {
				return;
			}
			
			
			if(canPlace(r, c, number)) {
				board[r][c] = number;
				backTrack(current + 1);
				board[r][c] = 0;
			}
		}
	}

	static boolean canPlace(int r, int c, int number) {
		for(int i = 0; i < 9; i++) {
			if(board[r][i] == number) {
				return false;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(board[i][c] == number) {
				return false;
			}
		}
		
		for(int i = r/3*3; i < r/3*3 + 3; i++) {
			for(int j = c/3*3; j < c/3*3 + 3; j++) {
				if(board[i][j] == number) {
					return false;
				}
			}
		}
		
		return true;
	}

	static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
