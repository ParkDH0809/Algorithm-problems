import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		getAnswer("");
	}
	
	static void getAnswer(String s) {
		if(s.length() == N) {
			System.out.println(s);
			return;
		}
		for(int i = 0; i <= 9; i++) {
			if(!isPrime(Integer.parseInt(s+i))) {
				continue;
			}
			getAnswer(s + i);
		}
	}
	
	static boolean isPrime(int n) {
		if(n == 0 || n == 1) {
			return false;
		}
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
