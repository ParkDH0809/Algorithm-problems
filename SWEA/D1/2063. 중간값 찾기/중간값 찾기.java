import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        bw.append(arr[N/2] + "");
        bw.flush();
    }
}