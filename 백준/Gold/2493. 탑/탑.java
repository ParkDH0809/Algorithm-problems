import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			map.put(i, Integer.parseInt(st.nextToken()));
		}

		int[] answer = new int[N];
		Stack<Integer> stack = new Stack<>();
		for(int i = N-1; i >= 0; i--) {
			
			while(!(stack.isEmpty() || map.get(stack.peek()) > map.get(i))) {
				answer[stack.pop()] = i+1;
			}
			
			stack.push(i);
		}
		
		for(int i : answer) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
	
}
