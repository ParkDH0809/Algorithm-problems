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
			String s = br.readLine();
            int[] arr = new int[26];
            for(char c : s.toCharArray())
                arr[c-'A']++;
            
            boolean check = true;
            for(int n : arr) {
                if(n != 0 && n != 2) {
                    check = false;
                    break;
                }
            }
            
            if(check)
                bw.append("#" + test_case + " Yes\n");
            else
                bw.append("#" + test_case + " No\n");
		}
        bw.flush();
	}
}