import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N >= K) {
			System.out.print(N - K);
			return;
		}

		Point[] visited = new Point[100001];
		for (int i = 0; i <= 100000; i++) {
			visited[i] = new Point();
		}

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if (visited[K].visited && visited[current].time >= visited[K].time) {
					continue;
				}

				if (current * 2 < 100001 && (!visited[current * 2].visited
						|| (visited[current * 2].visited && visited[current * 2].time > visited[current].time))) {
					queue.add(current * 2);
					visited[current * 2].time = visited[current].time;
					visited[current * 2].visited = true;
				}

				if (current + 1 < 100001 && (!visited[current + 1].visited
						|| (visited[current + 1].visited && visited[current + 1].time > visited[current].time))) {
					queue.add(current + 1);
					visited[current + 1].time = visited[current].time + 1;
					visited[current + 1].visited = true;
				}

				if (current - 1 > 0 && (!visited[current - 1].visited
						|| (visited[current - 1].visited && visited[current - 1].time > visited[current].time))) {
					queue.add(current - 1);
					visited[current - 1].time = visited[current].time + 1;
					visited[current - 1].visited = true;
				}
			}
		}
		System.out.print(visited[K].time);
	}
}

class Point {
	boolean visited;
	int time;

	Point() {
		visited = false;
		time = 0;
	}
}