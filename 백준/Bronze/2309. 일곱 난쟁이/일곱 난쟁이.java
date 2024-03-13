import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] arr;
	static int[] comb;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb = new int[7];
		
		Arrays.sort(arr);
		getAnswer(0, 0);
	}
	
	static void getAnswer(int sum, int count) {
		if(flag) {
			return;
		}
		
		if(count == 7) {
			if(sum == 100) {
				flag = true;
				printAnswer();
			}
			return;
		}
		
		for(int i = count; i < 9; i++) {
			comb[count] = arr[i];
			getAnswer(sum + arr[i], count+1);
		}
	}
	
	static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 7; i++) {
			sb.append(comb[i]).append("\n");
		}
		System.out.println(sb);
	}
}