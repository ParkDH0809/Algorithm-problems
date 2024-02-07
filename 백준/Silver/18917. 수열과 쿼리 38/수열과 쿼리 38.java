import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long sum = 0L;
		int xor = 0;
		int input;
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "1":
				input = Integer.parseInt(st.nextToken());
				sum += input;
				xor = xor^input;
				break;
				
			case "2":
				input = Integer.parseInt(st.nextToken());
				sum -= input;
				xor = xor^input;
				break;
				
			case "3":
				sb.append(sum).append("\n");
				break;
				
			case "4":
				sb.append(xor).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}