import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Deque<Index> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			Index current = new Index(Integer.parseInt(st.nextToken()), i);
			while (!deque.isEmpty() && deque.peekLast().number > current.number) {
				deque.pollLast();
			}

			deque.addLast(current);
			if (i - deque.peekFirst().index >= L) {
				deque.pollFirst();
			}

			sb.append(deque.peekFirst().number).append(' ');
		}

		System.out.print(sb);
	}

}

class Index {

	int number;
	int index;

	Index(int number, int index) {
		this.number = number;
		this.index = index;
	}

}