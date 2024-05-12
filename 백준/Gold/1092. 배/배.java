import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		N = Integer.parseInt(br.readLine());
		Integer[] crains = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crains[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		Integer[] boxes = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(crains, Collections.reverseOrder());
		Arrays.sort(boxes, Collections.reverseOrder());
		
		if (crains[0] < boxes[0]) {
			System.out.print(-1);
			return;
		}

		boolean[] selected = new boolean[M];
		int[] crainPoint = new int[N];

		int answer = 0;
		int count = 0;
		while (count < M) {
			for (int currentCrain = 0; currentCrain < N; currentCrain++) {
				for (int box = crainPoint[currentCrain]; box < M; box++) {
					if (crains[currentCrain] < boxes[box] || selected[box]) {
						crainPoint[currentCrain]++;
						continue;
					}
					
					selected[box] = true;
					crainPoint[currentCrain]++;
					count++;
					break;
				}
			}
			answer++;
		}

		System.out.print(answer);
	}
}