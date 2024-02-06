import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String command = br.readLine();
			
			br.readLine();
			String input = br.readLine();
			String inputArray = input.substring(1, input.length()-1);

			Deque<String> deque = new ArrayDeque<>();
			for(String s : inputArray.split(",")) {
				deque.add(s);
			}
			
			boolean check = true;
			boolean isError = false;
			for(char c : command.toCharArray()) {
				if(c == 'R') {
					check = !check;
					continue;
				}
				
				if(deque.isEmpty() || deque.peek().length() == 0) {
					isError = true;
					break;
				}
				
				if(check) {
					deque.removeFirst();
				} else {
					deque.removeLast();
				}
				
			}
			
			
			if(isError) {
				sb.append("error\n");
			} else {
				StringJoiner joiner = new StringJoiner(",", "[","]\n");
				if(check) {
					while(!deque.isEmpty()) {
						joiner.add(deque.pollFirst());
					}
				} else {
					while(!deque.isEmpty()) {
						joiner.add(deque.pollLast());
					}
				}
				sb.append(joiner);
			}
		}
		
		System.out.println(sb);
	}
	
}