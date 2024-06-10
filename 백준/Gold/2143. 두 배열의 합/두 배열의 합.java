import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] A = initArray(br);
		int[] B = initArray(br);
		System.out.print(getAnswer(T, initMap(A), B));
	}

	static int[] initArray(BufferedReader br) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return arr;
	}

	static HashMap<Integer, Integer> initMap(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				int sum = 0;
				for (int k = j; k <= j + i; k++) {
					sum += arr[k];
				}
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		return map;
	}

	static long getAnswer(int T, HashMap<Integer, Integer> map, int[] arr) {
		long answer = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				int sum = 0;
				for (int k = j; k <= j + i; k++) {
					sum += arr[k];
				}

				if (map.containsKey(T - sum)) {
					answer += map.get(T - sum);
				}
			}
		}
		return answer;
	}
}
