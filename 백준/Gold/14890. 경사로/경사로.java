import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        count += getCorrectCount();
        turnMap();
        count += getCorrectCount();
        System.out.print(count);
    }

    static int getCorrectCount() {
        int count = 0;
        for(int[] lane : map) {
            count += checkLane(lane) ? 1 : 0;
        }
//        for (int i = 0; i < N; i++) {
//            if(checkLane(map[i])) {
//                System.out.println(i + " true");
//            } else {
//                System.out.println(i + " false");
//            }
//        }
//        System.out.println("count: " + count);
        return count;
    }

    static boolean checkLane(int[] lane) {
//        System.out.println("---check start---");
        boolean[] isPlaced = new boolean[N];
        for(int i = 0; i < N-1; i++) {
            if (isSameNumber(lane[i], lane[i + 1])) {
                continue;
            }

            if (isDifferenceAtLeastTwo(lane[i], lane[i + 1])) {
                return false;
            }

            if(!(isPrevValueLarger(lane[i], lane[i + 1]) ? placeRightSlope(lane, i+1, isPlaced) : placeLeftSlope(lane, i, isPlaced))) {
                return false;
            }
        }
        return true;
    }

    private static boolean placeRightSlope(int[] lane, int current, boolean[] isPlaced) {
        if (current + L > N) {
            return false;
        }

        for (int i = current; i < current+L; i++) {
            if(!isSameNumber(lane[current], lane[i])) {
                return false;
            }

            isPlaced[i] = true;
        }
        return true;
    }

    private static boolean placeLeftSlope(int[] lane, int current, boolean[] isPlaced) {
        if (current < L-1) {

            return false;
        }

        for (int i = current - L+1; i <= current; i++) {
            if(isPlaced[i]) {
                return false;
            }

            if (!isSameNumber(lane[current], lane[i])) {
                return false;
            }

            isPlaced[i] = true;
        }
        return true;
    }

    static boolean isSameNumber(int n1, int n2) {
        return n1 == n2;
    }

    static boolean isDifferenceAtLeastTwo(int n1, int n2) {
        return Math.abs(n1 - n2) >= 2;
    }

    static boolean isPrevValueLarger(int n1, int n2) {
        return n1 > n2;
    }

    static void turnMap() {
        int[][] tempMap = new int[N][N];
        for(int i = 0; i < N; i++) {
            tempMap[i] = map[i].clone();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = tempMap[j][i];
            }
        }
    }

}
