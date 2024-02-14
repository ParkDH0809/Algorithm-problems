import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static boolean flag;
	static int R;
	static int C;
	static int answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for( int j = 0; j < C; j++) {
                map[i][j] = (input.charAt(j) == '.' ? true : false);
            }
        }

        for(int i = 0; i < R; i++) {
            flag = false;
            getAnswer(i, 0);
        }

        System.out.println(answer);
    }

    static void getAnswer(int r, int c) {
        int[] dr = {-1,0,1};

        if(c == C-1) {
            answer++;
            map[r][c] = false;
            flag = true;
            return;
        }

        for(int dir = 0; dir < 3; dir++) {
            int nr = r + dr[dir];
            int nc = c + 1;
    
            if(nr < 0 || nr == R || nc < 0 || !map[nr][nc]) {
                continue;
            }

            map[nr][nc] = false;
            getAnswer(nr, nc);

            if(flag) {
                return;
            }

        }
    }
}