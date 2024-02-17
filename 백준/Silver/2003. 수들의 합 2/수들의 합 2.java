import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int answer = 0;
        while(true) {
			if(sum >= M) {  
				sum -= input[start++];
				
			}
			else if(end >= N) {
				break;
			}
			else { 
				sum += input[end++];
			}
			
			if(sum == M) {
				answer++;
			}
		}

        System.out.println(answer);
    }
}