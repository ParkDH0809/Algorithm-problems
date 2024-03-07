import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '.' && !check(i, j)) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);
	}
	
	static boolean check(int r, int c ) {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int count = 0;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr == R || nc < 0 || nc == C || map[nr][nc] == 'X') {
				continue;
			}
			
			count++;
		}
		
		if(count < 2) {
			return false;
		}
		return true;
	}
	
}