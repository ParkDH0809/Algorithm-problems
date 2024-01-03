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
            int length = s.length();
            boolean check = true;
            for(int i = 0;i < length / 2; i++) {
                if(s.charAt(i) != s.charAt(length - (i+1)))
                    check = false;
            }
            
            if(check)
                bw.append("#" + test_case + " 1\n");
            else
                bw.append("#" + test_case + " 0\n");
		}
        bw.flush();
	}
}