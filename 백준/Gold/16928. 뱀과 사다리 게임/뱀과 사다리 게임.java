import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Point[] board = new Point[101];
		for (int i = 0; i <= 100; i++) {
			board[i] = new Point();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int ladderNumber = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		for (int i = 0; i < ladderNumber; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			board[from].ladder = true;
			board[from].to = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);

		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				int current = queue.poll();
				for(int i = 6; i >= 1; i--) {
					int n = current + i;
					
					if(n > 100) {
						continue;
					}
					
					if(n == 100) {
						System.out.println(count);
						return;
					}
					
					if(board[n].ladder) {
						n = board[n].to;
					}
					
					if(count < board[n].count) {
						board[n].count = count;
						queue.add(n);
					}
				}
			}
			count++;
		}
	}
}

class Point {

	boolean ladder;
	int count;
	int to;

	Point() {
		count = Integer.MAX_VALUE;
	}

}