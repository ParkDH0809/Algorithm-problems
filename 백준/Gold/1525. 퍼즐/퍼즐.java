import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final static int N = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] inputBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inputBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(getAnswer(inputBoard));
    }

    static int getAnswer(int[][] inputBoard) {
        Queue<int[][]> queue = new ArrayDeque<>();
        queue.add(inputBoard);

        Node visited = new Node();
        addVisitedData(visited, inputBoard);
        if (isAnswer(inputBoard)) {
            return 0;
        }

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[][] board = queue.poll();
                for (int[][] movedBoard : getMovedBoards(board)) {
                    if (isVisited(visited, movedBoard)) {
                        continue;
                    }

                    if (isAnswer(movedBoard)) {
                        return count;
                    }
                    // print(movedBoard);

                    addVisitedData(visited, movedBoard);
                    queue.add(movedBoard);
                }
            }
            count++;
        }

        return -1;
    }

    static void addVisitedData(Node node, int[][] board) {
        for (int[] rows : board) {
            for (int number : rows) {
                if (node.children[number] == null) {
                    node.children[number] = new Node();
                }
                node = node.children[number];
            }
        }
    }

    static List<int[][]> getMovedBoards(int[][] board) {
        List<int[][]> movedBoards = new ArrayList<>();
        int[] point = getZeroPoint(board);

        try {
            int[][] newBoard = getBoardClone(board);
            newBoard[point[0]][point[1]] = board[point[0] - 1][point[1]];
            newBoard[point[0] - 1][point[1]] = 0;
            movedBoards.add(newBoard);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        try {
            int[][] newBoard = getBoardClone(board);
            newBoard[point[0]][point[1]] = board[point[0]][point[1] - 1];
            newBoard[point[0]][point[1] - 1] = 0;
            movedBoards.add(newBoard);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        try {
            int[][] newBoard = getBoardClone(board);
            newBoard[point[0]][point[1]] = board[point[0] + 1][point[1]];
            newBoard[point[0] + 1][point[1]] = 0;
            movedBoards.add(newBoard);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        try {
            int[][] newBoard = getBoardClone(board);
            newBoard[point[0]][point[1]] = board[point[0]][point[1] + 1];
            newBoard[point[0]][point[1] + 1] = 0;
            movedBoards.add(newBoard);
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return movedBoards;
    }

    static int[][] getBoardClone(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    static int[] getZeroPoint(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    static boolean isVisited(Node node, int[][] board) {
        for (int[] rows : board) {
            for (int number : rows) {
                if (node.children[number] == null) {
                    return false;
                }
                node = node.children[number];
            }
        }
        return true;
    }

    static boolean isAnswer(int[][] board) {
        for (int i = 0; i < N * N - 1; i++) {
            if (board[i / N][i % N] != i + 1) {
                return false;
            }
        }
        return true;
    }

    static void print(int[][] board) {
        System.out.println();
        for (int[] rows : board) {
            for (int number : rows) {
                System.out.print(number);
            }
            System.out.println();
        }
    }

}

class Node {

    Node[] children;

    Node() {
        children = new Node[10];
    }

}