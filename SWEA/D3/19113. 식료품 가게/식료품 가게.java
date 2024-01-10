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
            
			int N = Integer.parseInt(br.readLine()) * 2;
            int[] arr = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) 
                arr[i] = Integer.parseInt(st.nextToken());
                       
            boolean[] visited = new boolean[N];
            int[] answer = new int[N/2];
            int count = 0;
            for(int i = N - 1; i >= 1; i--) {
                if(visited[i])
                    continue;
                
                int discount = arr[i] / 4 * 3;
                for(int j = i - 1; j >= 0; j--) {
                    if(arr[j] == discount && !visited[j]) {
                        visited[j] = true;
                        answer[count++] = discount;
                        break;
                    }
                }
            }
            
            for(int i = N/2 - 1; i >= 0; i--)
                bw.append(answer[i] + " ");
            bw.newLine();
		}
        bw.flush();
	}
}