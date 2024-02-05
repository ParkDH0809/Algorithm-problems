import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int count = 1;
		sb.append("<");
		while(!queue.isEmpty()) {
			if(count == K) {
				count = 0;
				sb.append(queue.poll());
				if(!queue.isEmpty()) {
					sb.append(", ");
				}
			} else {
				queue.add(queue.poll());
			}
			
			count++;
		}
		sb.append(">");
		System.out.println(sb);
	}
	
}