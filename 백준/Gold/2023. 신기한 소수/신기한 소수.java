import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int answer;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		getAnswer(0, 0);
		System.out.println(sb);
	}
	
	static void getAnswer(int number, int count) {
		if(count == N) {
			sb.append(number + "\n");
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			int current = number * 10 + i;
			if(isPrime(current)) {
				getAnswer(current, count+1);
			}
		}
	}
	
	static boolean isPrime(int number) {
		if(number == 0 || number == 1) {
			return false;
		}
		
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
