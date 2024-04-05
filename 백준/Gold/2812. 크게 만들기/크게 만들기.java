import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String input = br.readLine();
		int count = 0;
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			while(!stack.isEmpty() && count < K) {
				if(stack.peekLast() < c) {
					stack.pollLast();
					count++;
				} else {
					break;
				}
			}
			stack.addLast(c);
		}
		
		while(count < K) {
			stack.pollLast();
			count++;
		}
		
		
		while(!stack.isEmpty()) {
			sb.append(stack.pollFirst());
		}
		System.out.print(sb);
	}

}