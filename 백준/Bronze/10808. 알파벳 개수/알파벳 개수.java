import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int[] arr = new int[26];
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
		    arr[input.charAt(i) - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
		    sb.append(i).append(" ");
		}
		
		System.out.print(sb);
	}
}