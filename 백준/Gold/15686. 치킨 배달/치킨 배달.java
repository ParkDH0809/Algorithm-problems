import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Point> chickenShops;
	static List<Point> houses;
	static int[][] map;
	static int[][] distanceResult;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chickenShops = new ArrayList<>();
		houses = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					houses.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chickenShops.add(new Point(i, j));
				}
			}
		}

		initDistanceResult();
		initAnswer();
		getAnswer();
		System.out.println(answer);
	}
	
	static void initDistanceResult() {
		distanceResult = new int[chickenShops.size()][houses.size()];
		for (int chickenShop = 0; chickenShop < chickenShops.size(); chickenShop++) {
			for (int house = 0; house < houses.size(); house++) {
				distanceResult[chickenShop][house] = getDistance(chickenShop, house);			
			}
		}
	}
	
	static int getDistance(int chickenShop, int house) {
		return Math.abs(chickenShops.get(chickenShop).x - houses.get(house).x)
				+ Math.abs(chickenShops.get(chickenShop).y - houses.get(house).y);
	}
	
	static void initAnswer() {
		answer = Integer.MAX_VALUE;
	}
	
	static void getAnswer() {
		combination(0, 0, new boolean[chickenShops.size()]);
	}


	static void combination(int count,  int start, boolean[] visited) {
		if (count == M) {
			getCurrentCombinationsAnswer(visited);
			return;
		}

		for (int i = start; i < chickenShops.size(); i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			combination(count + 1, i + 1, visited);
			visited[i] = false;
		}
	}

	static void getCurrentCombinationsAnswer(boolean[] visited) {
		int[] arr = new int[M];
		int index = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i]) {
				arr[index++] = i;
			}
		}

		int sum = 0;
		for(int y = 0; y < distanceResult[0].length; y++) {
			int min = Integer.MAX_VALUE;
			for(int x = 0; x < distanceResult.length; x++) {
				if(ContainsXInArr(arr, x)) {
					min = Math.min(min, distanceResult[x][y]);
				}
			}
			sum += min;
		}
		
		answer = Math.min(answer,  sum);
	}
	
	static boolean ContainsXInArr(int[] arr, int x) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == x) {
				return true;
			}
		}
		return false;
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}