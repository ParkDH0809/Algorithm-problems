import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int answer = 0;
        int current = 0;
        while(current < N) {
            int f=0, t=N-1;
            while(f != t) {
                if(f == current) {
                    f++;
                    continue;
                } else if(t == current) {
                    t--;
                    continue;
                }
                
                int sum = arr[f] + arr[t];
                if(sum > arr[current]) {
                    t--;
                } else if(sum < arr[current]) {
                    f++;
                } else {
                    answer++;
                    break;
                }
            }
            current++;
        }
        
        bw.append(answer + "");
        bw.close();
    }
}