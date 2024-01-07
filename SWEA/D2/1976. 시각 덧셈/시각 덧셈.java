import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int hour = 0;
            int minute = 0;
            
            hour += Integer.parseInt(st.nextToken());
            minute += Integer.parseInt(st.nextToken());
            hour += Integer.parseInt(st.nextToken());
            minute += Integer.parseInt(st.nextToken());

            if(minute >= 60) {
                minute -= 60;
                hour += 1;
            }
            
            if(hour >= 13) {
                hour -= 12;
            }
            
            bw.append("#" + test_case + " " + hour + " " + minute);
            bw.newLine();
		}
        bw.flush();
	}
}