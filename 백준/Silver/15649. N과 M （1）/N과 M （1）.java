import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] answer = new int[M];
		boolean[] visited = new boolean[N];
		getAnswer(bw, answer, visited, 0);

		bw.append("");
		bw.close();
	}

	static void getAnswer(BufferedWriter bw, int[] answer, boolean[] visited, int count) throws IOException {
		if (count == M) {
			for (int i = 0; i < count; i++)
				bw.append(answer[i] + " ");
			bw.newLine();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			answer[count] = i+1;
			getAnswer(bw, answer, visited, count + 1);
			visited[i] = false;
		}
	}
}