import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] A;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		result[0] = A[0];
		for (int i = 0; i < N; i++) {
			if (check(A[i], 0, count)) {
				count++;
			}
		}
        
		System.out.print(count+1);
	}

	static boolean check(int number, int start, int end) {
		if(result[end] < number) {
			result[end + 1] = number;
			return true;
		}
		
		while(start < end) {
			int mid = (start + end) / 2;
			if(result[mid] == number) {
				return false;
			}
			
			if(result[mid] > number) {
				end = mid;
				continue;
			}
			
			if(result[mid] < number) {
				start = mid + 1;
			}
		}

        result[start] = number;
		return false;
	}
}