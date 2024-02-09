import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] board;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new boolean[102][102];


        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            changeBoard(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1);
        }

        System.out.println(getAnswer());
    }

    static void changeBoard(int r, int c) {
        for(int i = r; i < r + 10; i++) {
            for(int j = c;  j < c + 10; j++) {
                board[i][j] = true;
            }
        }
    }

    static int getAnswer() {
        return getRow() + getCol();
    }

    static int getRow() {
        boolean flag = false;
        int answer = 0;
        for(int i = 0; i < 102; i++) {
            for(int j = 0; j < 102; j++) {
                if(board[i][j] && !flag) {
                    answer++;
                    flag = true;
                } else if (!board[i][j] && flag) {
                    answer++;
                    flag = false;
                }
            }
        }
        return answer;
    }

    static int getCol() {
        boolean flag = false;
        int answer = 0;
        for(int i = 0; i < 102; i++) {
            for(int j = 0; j < 102; j++) {
                if(board[j][i] && !flag) {
                    answer++;
                    flag = true;
                } else if (!board[j][i] && flag) {
                    answer++;
                    flag = false;
                }
            }
        }
        return answer;
    }
    
}
 