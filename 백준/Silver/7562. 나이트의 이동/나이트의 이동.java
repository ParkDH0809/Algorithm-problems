import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7562. 나이트의 이동
public class Main {
	
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
        	int I = Integer.parseInt(br.readLine());
        	boolean[][] board = new boolean[I][I];
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	int[] sPoint = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	int[] ePoint = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        	
        	bw.append(bfs(board, sPoint, ePoint) + "\n");
        }
        
        bw.flush();
    }

	static int bfs(boolean[][] board, int[] sPoint, int[] ePoint) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(sPoint);
		
		int count = 0;
		out: while(true) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] currentPoint = queue.poll();
				int x = currentPoint[0];
				int y = currentPoint[1];
				
				if(x == ePoint[0] && y == ePoint[1]) {
					break out;
				}
				
				for(int dir = 0; dir < 8; dir++) {
					int xx = x + dx[dir];
					int yy = y + dy[dir];
					if(xx >= 0 && xx < board.length && yy >= 0 && yy < board.length && !board[xx][yy]) {
						queue.add(new int[] {xx, yy});
						board[xx][yy] = true;
					}
				}
			}
			count++;
		}
		
		return count;
	}
}