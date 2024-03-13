import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		int size = input.length();		
		
		StringBuilder tmp = new StringBuilder();
		boolean flag = false;
		
		for(int i = 0; i < size; i++) {
			char c = input.charAt(i);
			if(c == ' ' && !flag) {
				sb.append(tmp.reverse());
				tmp = new StringBuilder();
				sb.append(c);
				continue;
			}
			
			if(c == '<') {
				sb.append(tmp.reverse());
				tmp = new StringBuilder();
				sb.append(c);
				flag = true;
				continue;
			} else if(c == '>') {
				sb.append(c);
				flag = false;
				continue;
			}
			
			if(flag) {
				sb.append(c);
				continue;
			} else {
				tmp.append(c);
			}
		}
		
		sb.append(tmp.reverse());
		
		System.out.print(sb);
	}
}