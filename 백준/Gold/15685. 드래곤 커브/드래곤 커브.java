import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Dragon {
	List<Point> points = new ArrayList<>();
	Point endPoint;
	int direction;
	int generation;

	Dragon(Point startPoint, Point endPoint, int direction, int generation) {
		this.endPoint = endPoint;
		this.direction = direction;
		this.generation = generation;
		points.add(startPoint);
		points.add(endPoint);
	}
}

class Point {
	int y;
	int x;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {

	static boolean[][] map;
	static List<Dragon> dragons;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dragons = new ArrayList<>();
		map = new boolean[101][101];
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int generation = Integer.parseInt(st.nextToken());

			Point startPoint = new Point(y, x);
			if (direction == 0) {
				x++;
			} else if (direction == 1) {
				y--;
			} else if (direction == 2) {
				x--;
			} else {
				y++;
			}
			Point endPoint = new Point(y, x);

			map[startPoint.y][startPoint.x] = true;
			map[endPoint.y][endPoint.x] = true;
			dragons.add(new Dragon(startPoint, endPoint, direction, generation));

		}

		for (int i = 0; i < N; i++) {
			curveDragon(dragons.get(i));
		}
		System.out.println(getAnswer());
	}

	static void curveDragon(Dragon dragon) {

		for (int currentGeneration = 0; currentGeneration < dragon.generation; currentGeneration++) {
			List<Point> points = dragon.points;
			List<Point> newPoint = new ArrayList<>();
			for (int i = dragon.points.size() - 2; i >= 0; i--) {
				int finalX = dragon.endPoint.x + (dragon.endPoint.y - points.get(i).y);
				int finalY = dragon.endPoint.y - (dragon.endPoint.x - points.get(i).x);
				map[finalY][finalX] = true;
				
				newPoint.add(new Point(finalY, finalX));
			}
			dragon.points.addAll(newPoint);
			dragon.endPoint = newPoint.get(newPoint.size() - 1);
		}
	}

	static int getAnswer() {
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (isAnswer(i, j)) {
					answer++;
				}
			}
		}
		return answer;
	}

	static boolean isAnswer(int i, int j) {
		return map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1];
	}

}