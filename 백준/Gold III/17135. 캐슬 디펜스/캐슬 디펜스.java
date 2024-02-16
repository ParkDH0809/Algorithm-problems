import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Point> basicEnemyPoints;
	static int N;
	static int M;
	static int D;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		initNMD(br);
		initBasicEnemyPoints(br);
		disposeArcher(0, 0, new int[3]);
		System.out.println(answer);
	}

	static void initNMD(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
	}

	static void initBasicEnemyPoints(BufferedReader br) throws IOException {
		basicEnemyPoints = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1")) {
					basicEnemyPoints.add(new Point(i, j));
				}
			}
		}
	}

	static void disposeArcher(int start, int count, int[] selected) {
		if (count == 3) {
			playGame(initArcherPoints(selected), initEnemyPoints());
			return;
		}

		for (int i = start; i < M; i++) {
			selected[count] = i;
			disposeArcher(i + 1, count + 1, selected);
		}
	}

	static List<Point> initArcherPoints(int[] selected) {
		List<Point> archerPoints = new ArrayList<>();
		for (int i = 0; i < selected.length; i++) {
			archerPoints.add(new Point(N, selected[i]));
		}
		return archerPoints;
	}

	static List<Point> initEnemyPoints() {
		List<Point> enemyPoints = new ArrayList<>();
		for (int i = 0; i < basicEnemyPoints.size(); i++) {
			enemyPoints.add(new Point(basicEnemyPoints.get(i).x, basicEnemyPoints.get(i).y));
		}
		return enemyPoints;
	}

	static void playGame(List<Point> archerPoints, List<Point> enemyPoints) {
		int score = 0;
		while (!enemyPoints.isEmpty()) {
			score += killEnemy(initEnemyMinDistancePoint(archerPoints, enemyPoints), enemyPoints);
			moveEnemy(enemyPoints);
		}
		answer = Math.max(answer, score);
	}

	static List<Point> initEnemyMinDistancePoint(List<Point> archerPoints, List<Point> enemyPoints) {
		List<Point> minDistancePoints = new ArrayList<>();
		for (int i = 0; i < archerPoints.size(); i++) {
			minDistancePoints.add(getMinDistancePoint(archerPoints.get(i), enemyPoints));
		}
		return minDistancePoints;
	}

	static Point getMinDistancePoint(Point archerPoint, List<Point> enemyPoints) {
		int minDistance = Integer.MAX_VALUE;
		int minDistancePointX = Integer.MAX_VALUE;
		int minDistancePointY = Integer.MAX_VALUE;
		for (int i = 0; i < enemyPoints.size(); i++) {
			Point currentEnemyPoint = enemyPoints.get(i);
			int distance = Math.abs(currentEnemyPoint.x - archerPoint.x)
					+ Math.abs(currentEnemyPoint.y - archerPoint.y);

			if (distance > D) {
				continue;
			}

			if ((minDistance > distance) || (minDistance == distance && minDistancePointY > currentEnemyPoint.y)) {
				minDistance = distance;
				minDistancePointX = currentEnemyPoint.x;
				minDistancePointY = currentEnemyPoint.y;
			}
		}
		return new Point(minDistancePointX, minDistancePointY);
	}

	static int killEnemy(List<Point> minDistancePoints, List<Point> enemyPoints) {
		int score = 0;
		for (int i = 0; i < minDistancePoints.size(); i++) {
			for (int j = 0; j < enemyPoints.size(); j++) {
				if (minDistancePoints.get(i).equals(enemyPoints.get(j))) {
					enemyPoints.remove(j);
					score++;
					break;
				}
			}
		}
		return score;
	}

	static void moveEnemy(List<Point> enemyPoints) {
		for (int i = enemyPoints.size() - 1; i >= 0; i--) {
			enemyPoints.get(i).x++;

			if (enemyPoints.get(i).x >= N) {
				enemyPoints.remove(i);
			}
		}
	}

}

class Point {

	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		Point point = (Point) o;
		return this.x == point.x && this.y == point.y;
	}
	
}