import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    final static int BOARD_SIZE = 5;

    static char[][] numberBoard;
    static Set<String> values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberBoard = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                numberBoard[i][j] = st.nextToken().charAt(0);
            }
        }

        values = new HashSet<>();
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                find(r, c, 0, "");
            }
        }

        System.out.print(values.size());
    }

    static void find(int r, int c, int count, String str) {
        str += numberBoard[r][c];
        if (count == 5) {
            values.add(str);
            return;
        }

        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (!isInRange(nr, nc)) {
                continue;
            }

            find(nr, nc, count + 1, str);
        }
    }

    static boolean isInRange(int r, int c) {
        return r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE;
    }

}