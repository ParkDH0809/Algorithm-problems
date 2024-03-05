import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();
		
		if(L.length() != R.length() ) {
			System.out.println(0);
			return;
		}
		
		int count = 0;
		for(int i = 0; i < L.length(); i++) {
			if(L.charAt(i) != R.charAt(i)) {
				break;
			}
			
			if(L.charAt(i) == '8') {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
}