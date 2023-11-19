import java.io.*;
import java.util.*;

class Solution {
	static int[] arr;
	static ArrayList<Integer> sumResult;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr = new int[7];
			sumResult = new ArrayList<>();
			for(int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			method(0, 0, 0);
			Set<Integer> set = new HashSet<>(sumResult);
			sumResult = new ArrayList<>(set);
			Collections.sort(sumResult, Collections.reverseOrder());
			sb.append("#").append(test_case).append(" ").append(sumResult.get(4)).append("\n");
		}
        System.out.print(sb);
	}
	
	static void method(int count, int sum, int i) {
		if(count == 3) {
			sumResult.add(sum);
			return;
		}
		
		if(i == 7) {
			return;
		}
		
		method(count, sum, i + 1);
		method(count + 1, sum + arr[i], i + 1);
	}
}