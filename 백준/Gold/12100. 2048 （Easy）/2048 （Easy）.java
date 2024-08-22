import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] inputBoard = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                inputBoard[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<Board> boards = new ArrayDeque<>();
        boards.add(new Board(inputBoard, 0));
        System.out.print(play(boards));
    }

    private static int play(Queue<Board> boards) {
        int answer = 0;
        while (!boards.isEmpty()) {
            Board board = boards.poll();
            if (board.count == 5) {
                answer = Math.max(getMaxNumber(board.board), answer);
                continue;
            }
            for(int[][] turnedBoard : board.getTurnedBoards()) {
                boards.add(move(new Board(turnedBoard, board.count+1)));
            }
        }
        return answer;
    }

    private static Board move(Board board) {
        for(int r = 0; r < N; r++) {
            combinePerLine(board.board[r]);
        }
        return board;
    }

    private static void combinePerLine(int[] line) {
        boolean[] isMoved = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - (i+1); j++) {
                if (line[j] == 0) {
                    line[j] = line[j + 1];
                    line[j + 1] = 0;
                    isMoved[j] = isMoved[j + 1];
                    isMoved[j + 1] = false;
                    continue;
                }

                if (line[j] == line[j + 1] && !isMoved[j] && !isMoved[j+1]) {
                    line[j] *= 2;
                    line[j + 1] = 0;
                    isMoved[j] = true;
                }
            }
        }
    }

    private static int getMaxNumber(int[][] board) {
        int max = Integer.MIN_VALUE;
        for (int[] rows : board) {
            for (int cell : rows) {
                if (cell > max) {
                    max = cell;
                }
            }
        }
        return max;
    }

}

class Board {

    int count;
    int[][] board;

    Board(int[][] board, int count) {
        this.board = board.clone();
        this.count = count;
    }

    List<int[][]> getTurnedBoards() {
        List<int[][]> turnedBoards = new ArrayList<>();
        turnedBoards.add(board.clone());
        for(int i = 0; i < 3; i++) {
            turnedBoards.add(turnBoard(turnedBoards.get(i)));
        }
        return turnedBoards;
    }

    private int[][] turnBoard(int[][] inputBoard) {
        int N = board.length;
        int[][] turnedBoard = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                turnedBoard[r][c] = inputBoard[N - (c+1)][r];
            }
        }
        return turnedBoard;
    }

}