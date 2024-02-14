import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int H;
	static int W;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			int r = 0;
			int c = 0;
			int dir = 0;
			
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String input = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = input.charAt(j);
					if(map[i][j] == '^') {
						r = i;
						c = j;
						dir = 0;
					} else if(map[i][j] == 'v') {
						r = i;
						c = j;
						dir = 1;
					} else if(map[i][j] == '<') {
						r = i;
						c = j;
						dir = 2;
					} else if(map[i][j] == '>') {
						r = i;
						c = j;
						dir = 3;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for(int i = 0; i < N; i++) {
				switch(input.charAt(i)) {
				case 'S':
					shoot(r, c, dir);
					break;
				case 'U':
					dir = 0;
					if(move(r, c, dir)) {
						r--;
					}
					map[r][c] = '^';
					break;
				case 'D':
					dir = 1;
					if(move(r, c, dir)) {
						r++;
					}
					map[r][c] = 'v';
					break;
				case 'L':
					dir = 2;
					if(move(r, c, dir)) {
						c--;
					}
					map[r][c] = '<';
					break;
				case 'R':
					dir = 3;
					if(move(r, c, dir)) {
						c++;
					}
					map[r][c] = '>';
					break;
				}
			}
			
			sb.append("#").append(testCase).append(" ");
			for(char[] arr : map) {
				for(char ch : arr) {
					sb.append(ch);
				}
				sb.append("\n");
			}
		}
			
		System.out.println(sb);

	}
	
	static void shoot(int r, int c, int dir) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(true) {
			r = r + dr[dir];
			c = c + dc[dir];
			
			if(r < 0 || r == H || c < 0 || c == W || map[r][c] == '#') {
				break;
			}
			
			if(map[r][c] == '*') {
				map[r][c] = '.';
				break;
			}
		}
	}
	
	static boolean move(int r, int c, int dir) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
			map[r][c] = '.';
			return true;
		}
		
		return false;
	}
}