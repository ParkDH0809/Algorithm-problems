import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			deque.add(i);
		}

		StringBuilder sb = new StringBuilder();
		int number = 1;
		deque.poll();
		sb.append(1).append(" ");
		while (--N > 0) {
			if (numbers[number] > 0) {
				for (int i = 0; i < numbers[number] - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
				number = deque.pollFirst();
			} else {
				for (int i = 0; i < -numbers[number] - 1; i++) {
					deque.addFirst(deque.pollLast());
				}
				number = deque.pollLast();
			}
			sb.append(number).append(" ");
		}

		System.out.print(sb);
	}
}