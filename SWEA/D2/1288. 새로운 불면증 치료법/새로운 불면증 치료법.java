import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            boolean[] check = new boolean[10];
            int N = Integer.parseInt(br.readLine());
			
            int answer = 1;
			out: while(true) {
				int sum = N * answer;
                String s = String.valueOf(sum);
                for(char c : s.toCharArray()) {
                    if(!check[c - '0']) {
                        check[c - '0'] = true;
                    }
                }
                
                for(int i = 0; i < 10; i++) {
                    if(!check[i]) {
                        break;
                    }
                    if(i == 9 && check[9]) {
                        bw.append("#" + test_case + " " + sum + "\n");
                        break out;
                    }
                }
                answer++;
            }
		}
        bw.close();
	}
}