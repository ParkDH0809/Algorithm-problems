import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int W;
	static int H;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;

			int[][] board = new int[H][W];
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					board[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			play(board, 0);
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	static void play(int[][] board, int count) {
		if (count == N) {
			answer = Math.min(getAnswer(board), answer);
			return;
		}

		for (int i = 0; i < W; i++) {
			int[][] newBoard = initNewBoard(board);
			newBoard = remove(newBoard, i);
			newBoard = drop(newBoard);
			play(newBoard, count + 1);
		}
	}

	static int[][] initNewBoard(int[][] board) {
		int[][] newBoard = new int[H][W];
		for (int i = 0; i < H; i++) {
			System.arraycopy(board[i], 0, newBoard[i], 0, W);
		}
		return newBoard;
	}

	static int[][] remove(int[][] board, int w) {
		for (int h = 0; h < H; h++) {
			if (board[h][w] != 0) {
				explode(board, h, w, new boolean[H][W]);
				break;
			}
		}
		return board;
	}

	static void explode(int[][] board, int h, int w, boolean[][] visited) {
		visited[h][w] = true;
		
		int power = board[h][w];
		board[h][w] = 0;
		int[] dh = { 1, 0, -1, 0 };
		int[] dw = { 0, 1, 0, -1 };
		for (int dir = 0; dir < 4; dir++) {
			int nh = h;
			int nw = w;
			for (int p = 1; p < power; p++) {
				nh += dh[dir];
				nw += dw[dir];
				
				if(nh < 0 || nh == H || nw < 0 || nw == W) {
					break;
				}
				
				if(visited[nh][nw]) {
					continue;
				}
				
				if(board[nh][nw] != 0) {
					explode(board, nh, nw, visited);
				}
			}
		}
	}

	static int[][] drop(int[][] board) {
		for (int w = 0; w < W; w++) {
			int maxHeight = getMaxHeight(board, w);
			int currentHeight = maxHeight;
			while (currentHeight != H) {
				if (board[currentHeight][w] == 0) {
					for (int i = currentHeight; i > maxHeight; i--) {
						board[i][w] = board[i - 1][w];
						board[i - 1][w] = 0;
					}
					maxHeight++;
				}
				currentHeight++;
			}
		}
		return board;
	}

	static int getMaxHeight(int[][] board, int w) {
		for (int i = 0; i < H; i++) {
			if (board[i][w] != 0) {
				return i;
			}
		}
		return H;
	}

	static int getAnswer(int[][] board) {
		int answer = 0;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if (board[h][w] != 0) {
					answer++;
				}
			}
		}
		return answer;
	}

	static void print(int[][] board) {
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				System.out.print(board[h][w] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}