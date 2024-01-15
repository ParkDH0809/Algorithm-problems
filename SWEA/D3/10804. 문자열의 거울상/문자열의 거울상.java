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
            bw.append("#" + test_case + " ");
			String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for(int i = s.length() - 1; i >= 0 ; i--) {
                switch(s.charAt(i)) {
                    case 'p':
                        bw.append("q");
                        break;
                    case 'q':
                        bw.append("p");
                        break;
                    case 'b':
                        bw.append("d");
                        break;
                    default:
                        bw.append("b");
                }
            }
            bw.newLine();
		}
        bw.flush();
	}
}