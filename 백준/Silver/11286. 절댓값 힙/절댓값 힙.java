import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> queue = new PriorityQueue<>(
				new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (queue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(queue.poll() + "\n");
				}
			} else {
				queue.offer(input);
				
			}
		}
		
		System.out.println(sb);
	}
}