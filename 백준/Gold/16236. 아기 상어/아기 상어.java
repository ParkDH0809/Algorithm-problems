import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static Shark shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 9) {
                	shark = new Shark(r, c);
                    map[r][c] = 0;
                    continue;
                }
            }
        }

        int answer = 0;
        Fish monster = null;
        while((monster = search()) != null) {
            answer += monster.distance;
            shark.r = monster.r;
            shark.c = monster.c;
            map[shark.r][shark.c] = 0;
            shark.upExp();
        }

        System.out.print(answer);
    }

    static Fish search() {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<Fish> lowerMonsters = new PriorityQueue<>();
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{shark.r, shark.c});
        
        boolean[][] visited = new boolean[N][N];
        visited[shark.r][shark.c] = true;

        boolean searchFlag = false;
        int distance = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size -- > 0) {
                int[] point = queue.poll();
                for(int dir = 0; dir < 4; dir++)  {
                    int nr = point[0] + dr[dir];
                    int nc = point[1] + dc[dir];

                    if(!isRange(nr, nc)) {
                        continue;
                    }

                    if(visited[nr][nc]) {
                        continue;
                    }

                    if(map[nr][nc] > shark.level) {
                        continue;
                    }

                    if(map[nr][nc] == 0 || map[nr][nc] == shark.level) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        continue;
                    }

                    if(map[nr][nc] < shark.level) {
                        lowerMonsters.add(new Fish(nr, nc, distance));
                        searchFlag = true;
                    }
                }
            }

            if(searchFlag) {
                return lowerMonsters.poll();
            }

            distance++;
        }
        return null;
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}

class Shark {

    int r;
    int c;
    int level;
    int exp;

    Shark(int r, int c) {
        this.r = r;
        this.c = c;
        this.level = 2;
        this.exp = 0;
    }

    void upExp() {
        exp++;
        if(exp == level) {
            level++;
            exp = 0;
        }
    }
}

class Fish implements Comparable<Fish> {

    int r;
    int c;
    int distance;

    Fish(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }

    @Override
    public int compareTo(Fish o) {
        if(this.r != o.r) {
            return this.r - o.r;
        }
        return this.c - o.c;
    }
}