import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(getAnswer(board));
    }

    private static String getAnswer(char[][] board) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        addWords(board, pq);
        addWords(turnBoard(board), pq);
        return pq.poll();
    }

    private static void addWords(char[][] board, PriorityQueue<String> pq) {
        for (int r = 0; r < board.length; r++) {
            String str = "";
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '#') {
                    if (str.length() > 1) {
                        pq.add(str);
                    }
                    str = "";
                    continue;
                }
                str += board[r][c];
            }

            if (str.length() > 1) {
                pq.add(str);
            }
        }
    }

    private static char[][] turnBoard(char[][] board) {
        char[][] newBoard = new char[C][R];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                newBoard[c][r] = board[r][c];
            }
        }
        // print(newBoard);
        return newBoard;
    }

    static void print(char[][] board) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }

}