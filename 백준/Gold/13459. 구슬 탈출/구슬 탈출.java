import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static int[] redPoint;
    static int[] bluePoint;
    static int[] endPoint;
    static char[][] board;
    static boolean canDoit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        redPoint = new int[2];
        bluePoint = new int[2];
        endPoint = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = input.charAt(c);

                if (board[r][c] == 'R') {
                    redPoint[0] = r;
                    redPoint[1] = c;
                    continue;
                }

                if (board[r][c] == 'B') {
                    bluePoint[0] = r;
                    bluePoint[1] = c;
                    continue;
                }

                if (board[r][c] == 'O') {
                    endPoint[0] = r;
                    endPoint[1] = c;
                }
            }
        }

        int[] arr = new int[10];
        for (int dir = 0; dir < 4; dir++) {
        	arr[0] = dir;
            perm(arr, 1);        
            if(canDoit) {
                break;
            }
        }

        if (canDoit) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    static void perm(int[] result, int count) {
        if (count == 10) {
            play(result);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            if (result[count-1] == dir) {
                continue;
            }

            result[count] = dir;
            perm(result, count+1);

            if(canDoit) {
                return;
            }
        }
    }

    static void play(int[] result) {
        int[] red = new int[2];
        red[0] = redPoint[0];
        red[1] = redPoint[1];

        int[] blue = new int[2];
        blue[0] = bluePoint[0];
        blue[1] = bluePoint[1];

        for (int i = 0; i < 10; i++) {
            if (move(red, blue, result[i])) {
                canDoit = true;
            }

            if (move(blue, red, result[i])) {
                canDoit = false;
                return;
            }

            if (move(red, blue, result[i])) {
                canDoit = true;
            }

            if (canDoit) {
                return;
            }
        }
    }

    static boolean move(int[] point, int[] diff, int dir) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (true) {
            int nr = point[0] + dr[dir];
            int nc = point[1] + dc[dir];

            if (board[nr][nc] == '#') {
                return false;
            }

            if (board[nr][nc] == 'O') {
            	point[0] = nr;
                point[1] = nc;
                return true;
            }

            if (nr == diff[0] && nc == diff[1]) {
                return false;
            }

            
            point[0] = nr;
            point[1] = nc;
        }
    }
}