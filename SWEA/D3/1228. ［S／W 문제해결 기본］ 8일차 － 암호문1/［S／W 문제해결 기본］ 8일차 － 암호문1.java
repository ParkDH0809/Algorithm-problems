import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			
			int N = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			br.readLine();
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				st.nextToken();
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int i = 0; i < y; i++) {
					list.add(x+i, st.nextToken());
				}
			}
			
			sb.append("#").append(testCase).append(" ");
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}