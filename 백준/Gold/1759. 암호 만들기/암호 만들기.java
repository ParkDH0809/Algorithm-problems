import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static char[] alphabet;
	static int L;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sb = new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			char c = st.nextToken().charAt(0);
			alphabet[i] = c;
		}
		
		Arrays.sort(alphabet);
		
		combination(0, 0, new char[L], new boolean[C]);
		System.out.println(sb);
	}
	
	static void combination(int start, int count, char[] selected, boolean[] visited) {
		if(count == L) {
			if(isCorrect(selected)) {
				for(char c : selected) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			if(visited[i]) {
				continue;
			}
			
			visited[i] = true;
			selected[count] = alphabet[i];
			combination(i+1, count+1, selected, visited);
			visited[i] = false;
		}
	}
	
	static boolean isCorrect(char[] selected) {
		int vewelsNum = 0;
		for(char c : selected) {
			if(isVowels(c)) {
				vewelsNum++;
			}
		}
		if(vewelsNum >= 1 && selected.length - vewelsNum >= 2) {
			return true;
		}
		return false;
	}
	
	static boolean isVowels(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
}