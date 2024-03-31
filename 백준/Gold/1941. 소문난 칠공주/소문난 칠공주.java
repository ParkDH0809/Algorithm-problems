import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static char[][] map;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new char[5][5];
        for(int i = 0; i < 5; i++) {
            String input = br.readLine();
            for(int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        comb(new int[7], 0, 0, 0);
        System.out.print(answer);
    }

    static void comb(int[] selected, int start, int count, int sCount) {
        if(count == 7) {
            if(sCount < 4) {
                return;
            }

            if(isAnswer(selected)) {
                answer++;
            }
            return;
        }

        for(int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            selected[count] = i;
            if(map[r][c] == 'S') {
                comb(selected, i+1, count+1, sCount+1);
            } else {
                comb(selected, i+1, count+1, sCount);
            }
        }
    }

    static boolean isAnswer(int[] selected) {
        boolean[][] visited = new boolean[5][5];
        boolean[][] result = new boolean[5][5];
        for(int i = 0; i < selected.length; i++) {
            result[selected[i] / 5][selected[i] % 5] = true;
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(selected[0]);
        visited[selected[0] / 5][selected[0] % 5] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int r = current / 5;
            int c = current % 5;

            for(int dir = 0; dir < 4; dir++) {
                
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(!isRange(nr, nc)) {
                    continue;
                }

                if(visited[nr][nc]) {
                    continue;
                }

                if(result[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(nr*5 + nc);
                }
            }

            count++;
        }

        if(count == 7) {
            return true;
        }
        return false;
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}