import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int current = Integer.parseInt(br.readLine());

			if (left.isEmpty()) {
				left.add(current);
				sb.append(left.peek()).append("\n");
				continue;
			}

			int n = left.poll();
			if (current > n) {
				right.add(current);
				left.add(n);
			} else {
				right.add(n);
				left.add(current);
			}

			while (left.size() < right.size()) {
				left.add(right.poll());
			}

			sb.append(left.peek()).append("\n");
		}
		System.out.print(sb);
	}

}
