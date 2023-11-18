import java.util.*;
import java.io.*;

class Solution {
	static int N;
	static int answer;
	static ArrayList<Integer> list;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			for(int i = 2; i < N; i++) {
				if(isPrime(i)) {
					list.add(i);
				}
			}
			
			answer = 0;
			method(0, 0, 0);
			
			sb.append("#" + test_case + " " + answer + "\n");
		}
        System.out.print(sb);
	}
	
	static boolean isPrime(int n) {
		int sqrt = (int)Math.sqrt(n) + 1;
		for(int i = 2; i < sqrt; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static void method(int cor, int sum, int count) {
		if(count == 3) {
			if(sum == N) {
				answer++;
			}
			return;
		}
		
		if(cor >= list.size() || sum > N) {
			return;
		}
		
		method(cor, sum + list.get(cor), count + 1);
		method(cor + 1, sum, count);
		
	}
}