import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int count = Integer.parseInt(br.readLine());
            
            int[] arr = new int[100];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
                int current = Integer.parseInt(st.nextToken())-1;
                arr[current]++;
                min = Math.min(current, min);
                max = Math.max(current, max);
            }
            
            while(count-- > 0) {
                arr[max]--;
                arr[max-1]++;
                arr[min]--;
                arr[min+1]++;
                
                if(max - min <= 1) {
                    break;
                }
                
                if(arr[max] == 0) {
                    max--;
                }
                
                if(arr[min] == 0) {
                    min++;
                }
            }
            
            bw.append("#" + test_case + " " + (max - min));
            bw.newLine();
		}
        bw.flush();
	}
}