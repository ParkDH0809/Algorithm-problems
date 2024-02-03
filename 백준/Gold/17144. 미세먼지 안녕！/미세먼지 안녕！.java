import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] mainMap;
    static int[][] tempMap;
    static int R;
    static int C;
    static int T;
    static int AirCleanerTopPoint;
    static int AirCleanerBottomPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        mainMap = new int[R][C];
        tempMap = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < C; c++) {
                mainMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i < R; i++) {
            if (mainMap[i][0] == -1) {
                AirCleanerTopPoint = i;
                AirCleanerBottomPoint = i + 1;
                break;
            }
        }

        while (T-- > 0) {
            workDust();
            changeMap();
            workAirCleaner();
        }
        System.out.println(getDustSum());
    }

    static void workDust() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (mainMap[r][c] > 0) {
                    spreadDust(r, c);
                }
            }
        }
    }

    static void spreadDust(int r, int c) {
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        int count = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];

            if (nextR < 0 || nextR == R || nextC < 0 || nextC == C || mainMap[nextR][nextC] == -1) {
                continue;
            }

            tempMap[nextR][nextC] += (mainMap[r][c] / 5);
            count++;
        }

        tempMap[r][c] += (mainMap[r][c] - (mainMap[r][c] / 5) * count);

    }

    static void changeMap() {
        mainMap = tempMap;
        tempMap = new int[R][C];
    }

    static void workAirCleaner() {
        workCleaningTop();
        workCleaningBottom();
    }

    static void workCleaningTop() {
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        int r = AirCleanerTopPoint - 1;
        int c = 0;
        int dir =0;
        while (dir != 4) {
            int rr = r + dr[dir];
            int cc = c + dc[dir];

            if (cc < 0 || cc == C || rr < 0 || rr > AirCleanerTopPoint) {
                dir++;
                continue;
            }

            mainMap[r][c] = mainMap[rr][cc];
            r = rr;
            c = cc;

        }

        mainMap[AirCleanerTopPoint][0] = -1;
    }

    static void workCleaningBottom() {
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        int r = AirCleanerBottomPoint + 1;
        int c = 0;
        int dir =0;
        while (dir != 4) {
            int rr = r + dr[dir];
            int cc = c + dc[dir];

            if (cc < 0 || cc == C || rr == R || rr < AirCleanerBottomPoint) {
                dir++;
                continue;
            }

            mainMap[r][c] = mainMap[rr][cc];
            r = rr;
            c = cc;
        }

        mainMap[AirCleanerBottomPoint][0] = -1;
    }

    static int getDustSum() {
        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sum += mainMap[r][c];
            }
        }
        return sum + 2;
    }
}