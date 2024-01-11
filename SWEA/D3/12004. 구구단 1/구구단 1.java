import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            boolean check = false;
            for(int i = 1; i < 10; i++) {
                if(N % i == 0 && N / i < 10) {
                    check = true;
                }
            }
            
            bw.append("#" + test_case + " ");
            if(check) {
                bw.append("Yes\n");
            } else {
                bw.append("No\n");
            }
		}
        bw.flush();
	}
}