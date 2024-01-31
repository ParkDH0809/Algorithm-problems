import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		comb(0, 1);
		
		System.out.println(sb);
	}
	
	private static void comb(int count, int start) {
		if(count == M) {
			for(int i : arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			arr[count] = i;
			comb(count+1, i+1);
		}
	}
}
