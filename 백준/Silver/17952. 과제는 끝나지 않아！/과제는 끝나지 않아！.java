import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Task> stack = new Stack<>();
		int answer = 0;
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0")) {
				if(stack.isEmpty()) {
					continue;
				}
			} else {
				stack.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			answer += work(stack);
		}
		
		System.out.println(answer);
	}
	
	static int work(Stack<Task> stack) {
		Task currentTask = stack.pop();
		currentTask.time--;
		if(currentTask.time == 0) {
			return currentTask.score;
		}
		stack.add(currentTask);
		return 0;
	}
}

class Task {
	
	int time;
	int score;
	
	Task(int score, int time) {
		this.score = score;
		this.time = time;
	}
}