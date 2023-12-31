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
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) 
                A[i] = Integer.parseInt(st.nextToken());
            
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++) 
                B[i] = Integer.parseInt(st.nextToken());
            
            if(N < M)
            	bw.append("#" + test_case + " " + getAnswer(A, B) + "\n");
            else
                bw.append("#" + test_case + " " + getAnswer(B, A) + "\n");
		}
        bw.flush();
	}
    
    static int getAnswer(int[] minArr, int[] maxArr) {
        int answer = 0;
        
        for(int i = 0; i <= maxArr.length - minArr.length; i++) {
            int sum = 0;
            for(int j = 0; j < minArr.length; j++) {
                sum += minArr[j] * maxArr[j + i];
            }
            
            if(answer < sum)
                answer = sum;
        }
        
        return answer;
    }
}