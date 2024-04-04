import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main
 */
public class Main {

    static int answer;
    static int N;
    static int M;
    static int r;
    static int c;
    static int currentSide;
    static int direction;
    static int[][] map;
    static Dice dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int r = 0;  r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new Dice();
        answer = 0;
        r = 0;
        c = 0;
        currentSide = 6;
        direction = 1;
        while(K-- > 0) {
            play();
        }
        
        System.out.print(answer);
    }
    
    static void play() {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int nr = r + dr[direction];
        int nc = c + dc[direction];

        if(!isRange(nr, nc)) {
            direction = (direction + 2) % 4;
            r += dr[direction];
            c += dc[direction];
        } else {
            r = nr;
            c = nc;
        }
        
        answer += addScore(r, c);
        
        switch(direction) {
        case 0:
        	currentSide = dice.turnFront();
        	break;
        case 1:
        	currentSide = dice.turnRight();
        	break;
        case 2:
        	currentSide = dice.turnBack();
        	break;
        case 3:
        	currentSide = dice.turnLeft();
        	break;
        }

        if(map[r][c] > currentSide) {
            direction -= 1;
            if(direction == -1) {
                direction = 3;
            }
        } else if(map[r][c] < currentSide) {
            direction = (direction + 1) % 4;
        }
    }

    static int addScore(int r, int c) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        
        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nr = current[0] + dr[dir];
                int nc = current[1] + dc[dir];
     
                if(!isRange(nr, nc)) {
                    continue;
                }

                if(visited[nr][nc]) {
                    continue; 
                }

                if(map[nr][nc] != map[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
            count++;
        }

        return count * map[r][c];
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}

class Dice {
    
	int front;
	int back;
	int left;
	int right;
	int top;
	int bottom;
	
    Dice() {
    	top = 1;
    	bottom = 6;
    	left = 4;
    	right = 3;
    	front = 5;
    	back = 2;
    }
    
    int turnRight() {
    	int tmp = top;
    	top = left;
    	left = bottom;
    	bottom = right;
    	right = tmp;
    	return bottom;
    }
    
    int turnLeft() {
    	int tmp = top;
    	top = right;
    	right = bottom;
    	bottom = left;
    	left = tmp;
    	return bottom;
    }
    
    int turnFront() {
    	int tmp = top;
    	top = front;
    	front = bottom;
    	bottom = back;
    	back = tmp;
    	return bottom;
    }
    
    int turnBack() {
    	int tmp = top;
    	top = back;
    	back = bottom;
    	bottom = front;
    	front = tmp;
    	return bottom;
    }
    
}