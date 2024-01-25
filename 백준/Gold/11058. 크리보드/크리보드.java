import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		if(N == 1) {
			bw.append("1");
		} else if(N == 2) {
			bw.append("2");
		} else if(N == 3) {
			bw.append("3");
		} else {
			arr[0] = 1;
			arr[1] = 2;
			arr[2] = 3;

			for (int i = 3; i < N; i++) {
				arr[i] = arr[i - 1] + 1;
				for (int j = 3; j < i; j++) {
					arr[i] = Math.max(arr[i], arr[i - j] * (j - 1));
				}
			}
			bw.append(String.valueOf(arr[N - 1]));
		}
		
		bw.flush();
	}
}