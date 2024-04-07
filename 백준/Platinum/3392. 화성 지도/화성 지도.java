import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] count;
    static SegmentTree segmentTree;
    static PriorityQueue<Line> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        count = new int[30001];
        segmentTree = new SegmentTree();
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            pq.add(new Line(x1, y1, y2, 1));
            pq.add(new Line(x2, y1, y2, -1));
        }

        int answer = 0;
        int beforeX = 0;
        while(!pq.isEmpty()) {
            Line currentLine = pq.poll();
            answer += (currentLine.x - beforeX) * segmentTree.segementTree[1];
            beforeX = currentLine.x;
            update(currentLine); 
        }

        System.out.print(answer);
    }

    static void update(Line line) {
        for(int n = line.lowY; n < line.highY; n++) {
            int before = count[n];
            count[n] += line.isStartLine;

            if(before == 0 && count[n] != 0) {
                segmentTree.change(1, n, 1, 30001, 1);
                continue;
            }

            if(before != 0 && count[n] == 0) {
                segmentTree.change(1, n, 1, 30001, -1);
            }
        }
    }
}

class Line implements Comparable<Line> {

    int x;
    int lowY;
    int highY;
    int isStartLine;

    public Line(int x, int lowY, int highY, int isStartLine) {
        this.x = x;
        this.lowY = lowY;
        this.highY = highY;
        this.isStartLine = isStartLine;
    }

    @Override
    public int compareTo(Line o) {
        return x - o.x;
    }

    @Override
    public String toString() {
        return x + " [" + lowY + ":" + highY + "]" + ", " + isStartLine;
    }
}

class SegmentTree {

    int[] segementTree;

    SegmentTree() {
        segementTree = new int[65536];
    }

    void change(int node, int changeNode, int start, int end, int value) {
        if(changeNode < start || end < changeNode) {
            return;
        }

        segementTree[node] += value;

        if(start != end) {
            int mid = (start + end) / 2;
            change(node * 2, changeNode, start, mid, value);
            change(node * 2 + 1, changeNode, mid + 1, end, value);
        }
    }
}