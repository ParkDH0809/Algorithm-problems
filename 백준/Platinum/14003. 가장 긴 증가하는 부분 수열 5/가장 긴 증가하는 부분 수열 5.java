import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Number[] A;
	static Index[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		A = new Number[N];
		result = new Index[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = new Number(i, Integer.parseInt(st.nextToken()));
			result[i] = new Index();
		}

		int count = 0;
		result[0].stack.push(A[0]);
		for (int i = 0; i < N; i++) {
			if (check(A[i], 0, count)) {
				count++;
			}
		}
		
		sb.append(count+1).append("\n");
		int id = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack<>();
		for(int current = count; current >= 0; current--) {
			while(result[current].stack.peek().id > id) {
				result[current].stack.pop();
			}
			Number number = result[current].stack.pop();
			stack.push(number.value);
			id = number.id;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");	
		}
		
		System.out.print(sb);
	}

	static boolean check(Number number, int start, int end) {
		if(result[end].stack.peek().value < number.value) {
			result[end + 1].stack.add(number);
			return true;
		}
		
		while(start < end) {
			int mid = (start + end) / 2;
			if(result[mid].stack.peek().value == number.value) {
				return false;
			}
			
			if(result[mid].stack.peek().value > number.value) {
				end = mid;
				continue;
			}
			
			if(result[mid].stack.peek().value < number.value) {
				start = mid + 1;
			}
		}
		
		result[start].stack.add(number);
		return false;
	}
}

class Index {

	Stack<Number> stack;
	
	Index() {
		stack = new Stack<Number>();
	}
	
}

class Number {
	
	int id;
	int value;
	
	Number(int id, int value) {
		this.id = id;
		this.value = value;
	}
	
}