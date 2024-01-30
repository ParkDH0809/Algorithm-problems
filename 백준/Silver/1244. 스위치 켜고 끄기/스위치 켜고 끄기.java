import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int switchNum = Integer.parseInt(br.readLine());
		boolean[] switches = new boolean[switchNum+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switchNum; i++) {
			switches[i] = st.nextToken().equals("1");
		}

		int studentNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				changeCase1(switches, Integer.parseInt(st.nextToken()));
			} else {
				changeCase2(switches, Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 1; i < switches.length; i++) {
			if (switches[i]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
			
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

	static void changeCase1(boolean[] switches, int n) {
		
		for (int i = n; i < switches.length; i += n) {
			switches[i] = !switches[i];
		}
		
	}

	static void changeCase2(boolean[] switches, int n) {
		
		switches[n] = !switches[n];
		
		int count = 1;
		while (true) {
			
			if (n - count <= 0 || n + count >= switches.length) {
				return;
			}

			if (switches[n + count] != switches[n - count]) {
				return;
			}

			switches[n - count] = !switches[n - count];
			switches[n + count] = !switches[n + count];
			count++;
			
		}

	}

}
