import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		int N;
		int sum = 0;
		
		N = Integer.parseInt(br.readLine());
		sum += N > 40 ? N : 40;
		N = Integer.parseInt(br.readLine());
		sum += N > 40 ? N : 40;
		N = Integer.parseInt(br.readLine());
		sum += N > 40 ? N : 40;
		N = Integer.parseInt(br.readLine());
		sum += N > 40 ? N : 40;
		N = Integer.parseInt(br.readLine());
		sum += N > 40 ? N : 40;
		
		System.out.print(sum / 5);
	}
}